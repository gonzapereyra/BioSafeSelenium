pipeline {
    agent any
    triggers {
        pollSCM('* * * * *') // Opcional si no quieres usar Webhooks
    }
    stages {
        stage('Build') {
            steps {
                script {
                    bat 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    bat 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    echo 'Desplegando la aplicación…'
                }
            }
        }
    }
}
