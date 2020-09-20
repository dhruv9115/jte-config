def void buildImage(){
	directory("$WORKSPACE/${JOB_NAME}"){
		sh "docker push 705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:latest"
	}
}