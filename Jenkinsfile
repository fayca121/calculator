pipeline{
    agent any
    triggers{
     pollSCM('H/5 * * * *')
    }
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
        stage("Build"){
         steps{
           sh './mvnw -Dquarkus.package.type=legacy-jar -DskipTests package'
         }
        }
        stage("Publish ssh"){
          steps {
            sh 'scp ${WORKSPACE}/target/calculator-1.0-SNAPSHOT-runner.jar dockeradmin@dockerhost:/opt/calculator'
            sh 'scp ${WORKSPACE}/target/lib dockeradmin@dockerhost:/opt/calculator/lib'
          }
       }
    }
}