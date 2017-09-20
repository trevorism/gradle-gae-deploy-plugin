package com.trevorism.deploy.plugin.util

import org.junit.Test

/**
 * @author tbrooks
 */
class AppengineXmlParserTest {

    @Test
    void testParse() {
        Deploy deploy = AppengineXmlParser.parse(sampleXml())
        assert deploy
        assert deploy.application == "trevorism-gcloud"
        assert deploy.version == "1"
        assert deploy.service == "notRealService"
    }

    @Test
    void testParseNoService() {
        Deploy deploy = AppengineXmlParser.parse(sampleXmlNoService())
        assert deploy
        assert deploy.application == "trevorism-gcloud"
        assert deploy.version == "1"
        assert deploy.service == "trevorism-gcloud"
    }


    static String sampleXml(){
        """<?xml version="1.0" encoding="utf-8"?>
<appengine-web-app xmlns="http://appengine.google.com/ns/1.0">
    <runtime>java8</runtime>
    <application>trevorism-gcloud</application>
    <version>1</version>
    <service>notRealService</service>
    <threadsafe>true</threadsafe>
</appengine-web-app>
"""
    }

    static String sampleXmlNoService(){
        """<?xml version="1.0" encoding="utf-8"?>
<appengine-web-app xmlns="http://appengine.google.com/ns/1.0">
    <runtime>java8</runtime>
    <application>trevorism-gcloud</application>
    <version>1</version>
    <threadsafe>true</threadsafe>
</appengine-web-app>
"""
    }
}
