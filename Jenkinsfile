pipeline {
    agent any

    environment {
        PROJECT_NAME = 'semester project'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

     

          }

    post {
        always {
            cleanWs()
        }
    }
}
