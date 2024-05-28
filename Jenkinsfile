pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Setup Python') {
            steps {
                sh '''
                python3 -m venv venv
                source venv/bin/activate
                pip install --upgrade pip
                '''
            }
        }

        stage('Install Dependencies') {
            steps {
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
                sh '''
                source venv/bin/activate
                python semester_project.py
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
