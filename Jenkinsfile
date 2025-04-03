pipeline {
    agent any

    stages {
        stage("Build") { // Comillas rectas
            steps {
                script {
                    bat 'mvn clean install' // Usa 'bat' en Windows
                }
            }
        }

        stage("Test") {
            steps {
                script {
                    bat 'mvn test' // Cambiado a 'bat' para Windows
                }
            }
        }

        stage("Deploy") {
            steps {
                script {
                    echo 'Desplegando la aplicación...'
                }
            }
        }
    }
}
