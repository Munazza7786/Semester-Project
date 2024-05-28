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

     

       stage('Run Script') {
    steps {
        sh 'java -jar semester-project.java'
    }
}

    }

    post {
        always {
            cleanWs()
        }
    }
}
