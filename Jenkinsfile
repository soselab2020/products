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
				bat "set ATLAS_STRING=\"mongodb+srv://admin:admin6631@cluster0.ctev7.mongodb.net/demo?retryWrites=true&w=majority\""
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