def dockeruser = ""
def imagename = "openjdk"
def container = ""
node {
   echo 'Building Apache Docker Image'

stage('Git Checkout') {
    git 'https://github.com/rfmaa-iscteiul/ES2-2019-IC2-32'
    }
    
stage('Build Docker Imagae'){
     powershell "docker build -t  ${imagename} ."
    }
    
stage('Stop Existing Container'){
     powershell "docker stop ${container}"
    }
    
stage('Remove Existing Container'){
     powershell "docker rm ${container}"
    }
    
stage ('Runing Container to test built Docker Image'){
    powershell "docker run -dit --name ${container} -p 80:80 ${imagename}"
    }
    
stage('Tag Docker Image'){
    powershell "docker tag ${imagename} ${env.dockeruser}/ubuntu:16.04"
    }
}
