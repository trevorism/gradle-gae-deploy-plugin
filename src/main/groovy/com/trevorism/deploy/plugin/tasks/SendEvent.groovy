package com.trevorism.deploy.plugin.tasks

import com.trevorism.deploy.plugin.util.Deploy
import com.trevorism.event.DefaultEventProducer
import com.trevorism.event.EventProducer
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * @author tbrooks
 */
class SendEvent extends DefaultTask{

    String application
    String service
    String version

    @TaskAction
    void sendEvent(){
        Deploy deploy = new Deploy(application, service, version)
        EventProducer<Deploy> producer = new DefaultEventProducer<Deploy>()
        producer.sendEvent("deploy", deploy)

    }

}