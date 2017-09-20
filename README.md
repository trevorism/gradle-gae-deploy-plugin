# gradle-deploy-plugin

Adds an event to Google App Engine deploys

Add to your build like this:
```
buildscript {
	repositories {
        mavenCentral()
        maven {
            url "https://plugins.gradle.org/m2/"
        }
        maven {
            url uri("http://trevor.eastus.cloudapp.azure.com/nexus/content/repositories/releases")
        }
    }
	dependencies {
        classpath ':eventhub-client:1.0.0'
        classpath ':http-utils:1.0.0'
        classpath 'org.apache.httpcomponents:httpclient:4.5.3'
        classpath ':gradle-gae-deploy-plugin:1.0'
    }
}

apply plugin: "com.trevorism.gradle.acceptance"
```

Run with:
`gradle acceptanceTest`