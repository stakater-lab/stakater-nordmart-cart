#!/usr/bin/env groovy
@Library('github.com/stakater/stakater-pipeline-library@add-gradle-support') _

releaseApplication {
    appName = "cart"
    appType = "maven"
    builderImage = "stakater/builder-maven:3.5.4-jdk1.8-v2.0.1-v0.0.6"
    goal = "clean"
    notifySlack = false
    runIntegrationTest = false
    gitUser = "stakater-user"
    gitEmail = "stakater@gmail.com"
    usePersonalAccessToken = true
    tokenCredentialID = 'GithubToken'
    serviceAccount = "jenkins"
    dockerRepositoryURL = 'docker.release.stakater.com:443'
}