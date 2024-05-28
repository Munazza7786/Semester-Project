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
                sh '''
                # Activate virtual environment
                source venv/bin/activate

                # Run the Python script
                java semester_project.java
                '''
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
