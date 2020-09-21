def void buildImage(){
	dir("$WORKSPACE"){
		//sh "docker push 705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:latest"
		sh "docker build -t anagrams ."
	}
}


def void pushImage(){
        
        withCredentials([usernamePassword(credentialsId: 'ecr_cred', passwordVariable: 'ecr_password', usernameVariable: 'ecr_username')]) {
        	sh "docker login --username $ecr_username --password $ecr_password 705110607627.dkr.ecr.us-east-1.amazonaws.com"
    		sh "docker tag anagrams:latest 705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:latest"
    		sh "docker push 705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:latest"
}
    }
