#!/usr/bin/env groovy

node {
    stage('checkout') {
        checkout scm
    }

    stage('check java') {
        sh "java -version"
    }

    stage('clean') {
        sh "chmod +x mvnw"
        sh "./mvnw clean"
    }

    stage('backend tests') {
        try {
            sh "./mvnw test"
        } catch(err) {
            throw err
        } finally {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }

    stage('packaging') {
        sh "./mvnw verify -Pprod -DskipTests"
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }

//    stage('quality analysis') {
//        withSonarQubeEnv('sonar') {
//            sh "./mvnw sonar:sonar"
//        }
//    }

    def dockerImage
    stage('build docker') {
        sh "cp -R src/main/docker target/"
        sh "cp target/*.war target/docker/"
        dockerImage = docker.build('stencil/b2x', 'target/docker')
    }

    stage('publish docker') {
        sh '$(aws ecr get-login --no-include-email --region ap-southeast-1)'
        docker.withRegistry('613175009525.dkr.ecr.ap-southeast-1.amazonaws.com/stencil-template-project', '$(aws ecr get-login --no-include-email --region ap-southeast-1)') {
            dockerImage.push 'latest'
        }
    }
}
