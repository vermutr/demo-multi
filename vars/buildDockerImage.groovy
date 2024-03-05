def call(String imageName, String tag = 'latest') {
    def dockerBuildCommand = "docker build -t ${imageName}:${tag} ."

    try {
        echo "Running Docker build for image: ${imageName}:${tag}"
        sh dockerBuildCommand
        echo "Docker build completed successfully."
    } catch (Exception e) {
        echo "Error during Docker build: ${e.message}"
        throw e
    }
}