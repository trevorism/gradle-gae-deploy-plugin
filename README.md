# gradle-deploy-plugin

Adds an event to Google App Engine deploys

Add to your build like this:
```
buildscript {
	repositories {
        mavenCentral()
        maven {
            url uri("http://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-releases")
        }
    }
	dependencies {
        classpath 'com.trevorism:gradle-gae-deploy-plugin:1.2.0'
    }
}

apply plugin: "com.trevorism.gradle.gae.deploy"
```

Run with:
`gradle appengineDeploy`