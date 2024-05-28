pipeline {
    agent any

    environment {
        PROJECT_NAME = 'Semester Project'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Setup Python') {
            steps {
                sh '''
                if ! command -v python3 &> /dev/null
                then
                    echo "Python3 could not be found"
                    exit 1
                fi
                
                if ! python3 -m venv venv &> /dev/null
                then
                    echo "Creating virtual environment failed. Installing python3-venv."
                    sudo apt-get update
                    sudo apt-get install -y python3-venv
                    python3 -m venv venv
                fi
                
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
