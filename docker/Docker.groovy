def void buildImage(){
	dir("$WORKSPACE"){
		//sh "docker push 705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:latest"
		sh "docker build -t anagrams ."
	}
}