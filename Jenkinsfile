pipeline {
    agent any

    tools{
      maven 'Maven3'
      jdk 'JDK_21'
      }

    stages {
        stage ('build') {
              steps{
                sh 'mvn clean install'
              }
             }

             stage('Test & Coverage') {
                    steps {
                        sh 'mvn test jacoco:report' // Runs tests & generates JaCoCo coverage report
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml' // Publish JUnit test results
                            jacoco execPattern: '**/target/jacoco.exec', // Reads JaCoCo execution file
                                   classPattern: '**/target/classes',
                                   sourcePattern: '**/src/main/java',
                                   exclusionPattern: '**/test/**'
                        }
                    }
          }

        }
}
