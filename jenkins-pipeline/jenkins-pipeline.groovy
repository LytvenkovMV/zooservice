pipeline {
    agent any

    environment {
        GITHUB_REPO = 'https://github.com/LytvenkovMV/zooservice'
        DOCKER_IMAGE_NAME = 'zooservice-image'
        DOCKER_CONTAINER_NAME = 'zooservice-cont'
    }

    stages {
        stage('Checkout') {
            steps {
                // Клонирование репозитория из GitHub
                git branch: 'master', url: "${GITHUB_REPO}"
            }
        }

        stage('Create Docker Image') {
            steps {
                // Создание Docker образа
                script {
                    docker.build("${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}")
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                // Остановка и удаление существующего контейнера (если есть)
                sh "docker stop ${DOCKER_CONTAINER_NAME} || true"
                sh "docker rm ${DOCKER_CONTAINER_NAME} || true"

                // Запуск нового контейнера
                sh "docker run -d --name ${DOCKER_CONTAINER_NAME} ${DOCKER_IMAGE_NAME}:${BUILD_NUMBER}"
            }
        }
    }

    post {
        always {
            // Очистка рабочего пространства
            cleanWs()
        }
    }
}