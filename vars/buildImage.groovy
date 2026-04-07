#!/user/bin/env groovy

def call() {
    echo"building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable:'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t emrearabacioglu/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push emrearabacioglu/demo-app:jma-2.0'
    }
}