pipeline {
    agent any

    tools{
      maven 'Maven3'
      jdk 'JDK_21'
      }

    stages {
        stage ('build') {
              steps{
                bat 'mvn clean install'
              }
             }

             stage('Test & Coverage') {
                    steps {
                        sh 'mvn test jacoco:report'
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                            jacoco execPattern: '**/target/jacoco.exec',
                                   classPattern: '**/target/classes',
                                   sourcePattern: '**/src/main/java',
                                   exclusionPattern: '**/test/**'
                        }
                    }
          }

        }
}
