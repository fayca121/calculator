pipeline{
    agent any
    stages{
        stage("Compile"){

            steps{
            sh 'chmod 777 mvnw'
            sh './mvnw clean compile'
            }
        }

        stage("Unit Test"){
            steps{
            sh './mvnw test'
            }
            }
        stage("Code coverage"){
        steps {
          sh './mvnw verify'
          publishHTML (target: [
           reportDir: 'target/jacoco-report/',
           reportFiles: 'index.html',
           reportName: 'JaCoCo Report'
          ])
        }
        }

    }
}