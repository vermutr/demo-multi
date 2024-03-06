def call(String imageName, String tag = 'latest', String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin 192.168.92.61:8081"

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