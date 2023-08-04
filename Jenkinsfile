node {
	stage('Checkout') {
		git url: 'https://github.com/rabaraaaron/RegistrationService'
	}
	stage('Gradle build') {
		bat: 'gradle build'
	}
}