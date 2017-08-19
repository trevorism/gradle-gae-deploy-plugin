package com.trevorism.deploy.plugin

import com.trevorism.deploy.plugin.tasks.SendEvent
import com.trevorism.deploy.plugin.util.AppengineXmlParser
import com.trevorism.deploy.plugin.util.Deploy
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class DeployPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {

        String text = project.file("src/main/webapp/WEB-INF/appengine-web.xml").text
        if(!text)
            throw new GradleException("Unable to find appengine-web.xml. This must exist for this plugin to work/")

        Deploy deploy = AppengineXmlParser.parse(text)

        project.task("sendDeployEvent", type: SendEvent){
            dependsOn "appengineDeploy"
            application = deploy.application
            service = deploy.service
            version = deploy.version
        }

        project.tasks.findByPath("appengineDeploy")?.finalizedBy("sendDeployEvent")

    }

}
