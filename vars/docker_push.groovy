def call(String CredId, String ProjectName, String ImageTag){
    withCredentials([usernamePassword(
            credentialsId: CredId,
            usernameVariable: 'dockerHubUser', 
            passwordVariable: 'dockerHubPass')]) {
        // Docker login using the credentials
        sh "echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin"
        
        // Push the Docker image
        sh "docker push ${dockerHubUser}/${ProjectName}:${ImageTag}"
    }
}
