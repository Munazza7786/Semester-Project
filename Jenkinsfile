pipeline {
    agent any

    environment {
        // Define any environment variables if needed
        PROJECT_NAME = 'Semester Project'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                checkout scm
            }
        }

        stage('Setup Python') {
            steps {
                // Install Python and set up virtual environment
                sh '''
                python3 -m venv venv
                source venv/bin/activate
                pip install --upgrade pip
                '''
            }
        }

        stage('Install Dependencies') {
            steps {
                // If you have a requirements.txt file, you can install dependencies
                sh '''
                source venv/bin/activate
                if [ -f requirements.txt ]; then
                    pip install -r requirements.txt
                fi
                '''
            }
        }

        stage('Run Script') {
            steps {
                script {
                    // Run your Python script
                    sh '''
                    source venv/bin/activate
                    python semester_project.py
                    '''
                }
            }
        }

        // Optional: Add more stages for testing, packaging, or deployment if necessary
    }

    post {
        always {
            // Clean up
            cleanWs()
        }
    }
}
