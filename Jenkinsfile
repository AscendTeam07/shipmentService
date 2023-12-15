pipeline {
    agent any

    environment {
        // Define your Maven and Docker credentials
        MAVEN_HOME = tool 'Maven3.8.9'
        DOCKER_HUB_CREDENTIALS = credentials('dockerhub')
        DOCKER_IMAGE_NAME = "nagendraranga/shipmentservice"
        DOCKER_IMAGE_TAG = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from your version control system (e.g., Git)
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build the Maven project
                bat "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build Docker image
                script {
                    dockerImage = docker.build("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}", "-f Dockerfile .")
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                // Push Docker image to Docker Hub
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_HUB_CREDENTIALS) {
                        dockerImage.push()
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Build and push to Docker Hub successful!"
        }
        failure {
            echo "Build or push to Docker Hub failed"
        }
    }
}
