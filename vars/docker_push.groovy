def call(String CredId, String Project, String ImageTag){
    withCredentials([usernamePassword(
            credentialsId: CredId,
            usernameVariable: 'dockerHubUser', 
            passwordVariable: 'dockerHubPass')]) {
        sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
       
        sh "docker image tag ${Project}:${ImageTag} ${dockerHubUser}/${Project}:${ImageTag}"
       
        sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
    }
}
