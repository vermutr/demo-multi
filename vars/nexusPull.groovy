def call(String imageName, String tag = 'latest', String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin 192.168.92.61:8082"

        def dockerPushCommand = "docker pull 192.168.92.61:8082/repository/my-test-repo:latest"

        try {
            echo "Pulling Docker image to registry: ${imageName}:${tag}"
            sh dockerPushCommand
            echo "Docker image Pulled successfully."
            sh "docker images"
        } catch (Exception e) {
            echo "Error during Docker Pulling: ${e.message}"
            throw e
        } finally {
            sh "docker logout"
        }
    }
}