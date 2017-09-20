package com.trevorism.deploy.plugin

import com.trevorism.deploy.plugin.tasks.SendEvent
import com.trevorism.deploy.plugin.util.AppengineXmlParserTest
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author tbrooks
 */
class DeployPluginTest {

    @Test
    void testApply() {
        Project project = newProject()
        assert project.tasks.findByPath("sendDeployEvent") instanceof SendEvent

        project.tasks.sendDeployEvent.execute()

    }

    static Project newProject(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        String path = "${project.projectDir.path}/src/main/webapp/WEB-INF/"
        new File(path).mkdirs()
        new File("${path}/appengine-web.xml") << AppengineXmlParserTest.sampleXml()
        project.with {
            apply plugin: "com.trevorism.gradle.gae.deploy"

        }

        return project
    }
}
