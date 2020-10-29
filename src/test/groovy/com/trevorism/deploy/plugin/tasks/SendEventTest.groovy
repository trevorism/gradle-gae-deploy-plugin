package com.trevorism.deploy.plugin.tasks

import com.trevorism.deploy.plugin.DeployPluginTest
import com.trevorism.event.EventProducer
import org.gradle.api.Project
import org.junit.Test

class SendEventTest {

    @Test
    void testSendEvent() {
        Project project = DeployPluginTest.newProject()
        SendEvent sendEventTask = project.tasks.sendDeployEvent
        sendEventTask.application = "testApp"
        sendEventTask.service = "testService"
        sendEventTask.version = "1.0.0"
        sendEventTask.producer = [sendEvent: {topic, event ->
            println "here"
            assert true}] as EventProducer
        sendEventTask.sendEvent()
    }
}
