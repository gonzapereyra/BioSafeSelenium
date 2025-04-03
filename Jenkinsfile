pipeline {
    agent any
    triggers {
        pollSCM('* * * * *') // Opcional si no quieres usar Webhooks
    }
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
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
