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
           sh './mvnw -DskipTests package'
         }
        }
        stage("Publish"){
          steps([$class: 'BapSshPromotionPublisherPlugin']) {
           script{
            sshPublisher(
               publishers: [
                sshPublisherDesc(
                 configName: DockerHost,
                  transfers: [
                   sourceFiles: 'target/calculator-1.0-SNAPSHOT-runner.jar,target/lib/**/',
                   removePrefix: 'target',
                   remoteDirectory: '/opt/calculator'
                  ],
                  usePromotionTimestamp: false,
                  useWorkspaceInPromotion: false,
                  verbose: false
                )
               ]
            )
           }
          }
        }

    }
}