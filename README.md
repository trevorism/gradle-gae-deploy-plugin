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
        classpath ':gradle-gae-deploy-plugin:1.1.1'
    }
}

apply plugin: "com.trevorism.gradle.gae.deploy"
```

Run with:
`gradle appengineDeploy`