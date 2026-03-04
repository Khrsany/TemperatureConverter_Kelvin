pipeline {
  agent any

  tools {
    maven 'Maven_3'
  }

  options {
    timestamps()
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        sh 'mvn -v'
        sh 'mvn -B clean test'
      }
    }
  }

  post {
    always {
      junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

      archiveArtifacts artifacts: 'target/site/jacoco/**', allowEmptyArchive: true
    }
  }
}
