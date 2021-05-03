# gradle-deploy-plugin

![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/gradle-gae-deploy-plugin)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/gradle-gae-deploy-plugin)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/gradle-gae-deploy-plugin)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/gradle-gae-deploy-plugin)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/gradle-gae-deploy-plugin)

Adds an event to Google App Engine deploys

Add to your build like this:
```
buildscript {
	repositories {
        mavenCentral()
        maven {
            url uri("https://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-releases")
        }
    }
	dependencies {
        classpath 'com.trevorism:gradle-gae-deploy-plugin:2.0.0'
    }
}

apply plugin: "com.trevorism.gradle.gae.deploy"
```

Run with:
`gradle appengineDeploy`