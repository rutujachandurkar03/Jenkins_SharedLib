def call(String CredId, String ProjectName, String ImageTag){
    withCredentials([usernamePassword(
            credentialsId: CredId,
            usernameVariable: 'dockerHubUser', 
            passwordVariable: 'dockerHubPass')]) {
        // Docker login using the credentials
        sh "echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin"
        
        // Tag the Docker image
        sh "docker image tag ${ProjectName}:${ImageTag} ${env.dockerHubUser}/${ProjectName}:${ImageTag}"
        
        // Push the Docker image
        sh "docker push ${env.dockerHubUser}/${ProjectName}:${ImageTag}"
    }
}
