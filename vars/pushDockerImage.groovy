def call(String imageName, String tag = 'latest', String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "echo '${env.DOCKER_PASSWORD}' | docker login --username ${env.DOCKER_USERNAME} --password-stdin"

        def dockerPushCommand = "docker push ${imageName}:${tag}"

        try {
            echo "Pushing Docker image to registry: ${imageName}:${tag}"
            sh dockerPushCommand
            echo "Docker image pushed successfully."
        } catch (Exception e) {
            echo "Error during Docker push: ${e.message}"
            throw e
        } finally {
            sh "docker logout"
        }
    }
}