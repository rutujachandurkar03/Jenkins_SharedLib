def call(String CredId, String Project, String ImageTag){

 withCredentials([usernamePassword(
                    credentialsId:"CredId",
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
                sh "docker image tag ${imageName}:${imageTag} ${env.dockerHubUser}/${imageName}:${imageTag}"
                sh "docker push ${env.dockerHubUser}/${imageName}:${imageTag}"
