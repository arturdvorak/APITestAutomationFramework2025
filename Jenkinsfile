pipeline {
    agent any

    tools {
        maven 'M3'
    }

    environment {
        QASE_TOKEN = credentials('qase_token_id')  // stored in Jenkins credentials
        BASE_URL = 'https://api.qase.io/v1/'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/arturdvorak/APITestAutomationFramework2025.git'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn clean test -Dtoken=$QASE_TOKEN -Durl=$BASE_URL'
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}