package com.trevorism.deploy.plugin.tasks

import com.trevorism.deploy.plugin.util.Deploy
import com.trevorism.event.EventProducer
import com.trevorism.event.PingingEventProducer
import com.trevorism.https.DefaultInternalTokenSecureHttpClient
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

/**
 * @author tbrooks
 */
class SendEvent extends DefaultTask{

    String application
    String service
    String version

    EventProducer<Deploy> producer = new PingingEventProducer<Deploy>(new DefaultInternalTokenSecureHttpClient())

    @TaskAction
    @Internal
    void sendEvent(){
        Deploy deploy = new Deploy(application, service, version)
        producer.sendEvent("deploy", deploy)
    }

}