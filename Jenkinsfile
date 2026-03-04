pipeline {
  agent any

  tools {
    maven 'Maven_3'
    // jos sulla on Jenkinsissä JDK nimellä esim. "JDK17", laita se tähän:
    // jdk 'JDK17'
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
      junit 'target/surefire-reports/*.xml'
    }
  }
}
