node {
	stage('Checkout') {
		git url: 'https://github.com/rabaraaaron/RegistrationService', branch: 'main'
	}
	stage('Gradle build') {
		bat: 'gradle build'
	}
}