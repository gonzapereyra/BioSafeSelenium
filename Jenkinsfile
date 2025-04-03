pipeline {
agent any // Permite que Jenkins ejecute este Pipeline en cualquier agente disponible
stages { // Definimos las etapas del proceso
stage(‘Build’) { // Primera etapa: Compilación
steps {
script {
sh ‘mvn clean install’ // Comando para construir el proyecto (si usas Maven)
}
}
}
stage(‘Test’) { // Segunda etapa: Pruebas
steps {
script {
sh ‘mvn test’ // Comando para ejecutar las pruebas
}
}
}
stage(‘Deploy’) { // Tercera etapa: Despliegue
steps {
script {
echo ‘Desplegando la aplicación…’ // Aquí puedes añadir comandos para el despliegue
}
}
}
}
}
