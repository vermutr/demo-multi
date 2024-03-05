def call(String tasks) {
    sh "chmod +x ./gradlew"
    sh "./gradlew ${tasks}"
}