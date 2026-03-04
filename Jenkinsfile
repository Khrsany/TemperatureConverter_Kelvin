pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn -B clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'

            jacoco(
                execPattern: 'target/jacoco.exec',
                classPattern: 'target/classes',
                sourcePattern: 'src/main/java',
                exclusionPattern: '**/*Test*'
            )
        }
    }
}