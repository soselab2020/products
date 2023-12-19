pipeline {
	agent any

	stages {

		stage('Build'){
			steps {
				bat "mvn clean"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

		stage('Deploy') {
			steps {
				bat "mvn package"
			    bat "java -jar target/springboot-0.0.1-SNAPSHOT.jar"
			}
		}
	}
}