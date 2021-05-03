package com.trevorism.deploy.plugin.util

import groovy.xml.XmlSlurper
/**
 * @author tbrooks
 */
class AppengineXmlParser {

    static Deploy parse(String xmlText){
        XmlSlurper slurper = new XmlSlurper()
        def xml = slurper.parseText(xmlText)

        String service = xml.service
        Deploy deploy = new Deploy()
        deploy.application = xml.application
        deploy.service = service ?: deploy.application
        deploy.version = xml.version
        return deploy
    }

}
