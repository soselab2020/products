pipeline {
	agent any

	stages {

		stage('Build'){
			steps {
				bat "mvn clean"
				bat "mvn compile"
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
			    bat "xcopy /y target\\springboot-0.0.1-SNAPSHOT.jar d:\\Test\\products.jar"
			}
		}
	}
}