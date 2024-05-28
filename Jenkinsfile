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

        stage('Setup Python') {
            steps {
                sh '''
                # Check if python3 is installed
                if ! command -v python3 &> /dev/null
                then
                    echo "Python3 could not be found"
                    exit 1
                fi

                # Install python3-venv if not already installed
                if ! python3 -m venv --help &> /dev/null
                then
                    echo "Creating virtual environment failed. Installing python3-venv."
                    sudo apt-get update
                    sudo apt-get install -y python3-venv
                fi

                # Create virtual environment
                python3 -m venv venv

                # Activate virtual environment and upgrade pip
                source venv/bin/activate
                pip install --upgrade pip
                '''
            }
        }

        stage('Install Dependencies') {
            steps {
                sh '''
                # Activate virtual environment
                source venv/bin/activate

                # Install dependencies from requirements.txt if it exists
                if [ -f requirements.txt ]; then
                    pip install -r requirements.txt
                fi
                '''
            }
        }

        stage('Run Script') {
            steps {
                sh '''
                # Activate virtual environment
                source venv/bin/activate

                # Run the Python script
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
