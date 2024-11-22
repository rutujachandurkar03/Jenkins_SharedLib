def call(String CredId, String Project, String ImageTag){
  withCredentials([usernamePassword(credentialsId: 'CredId', 
                                    passwordVariable: 'dockerHubPass',
                                    usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
