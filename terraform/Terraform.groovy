def updateProvider(String path){
    withCredentials([usernamePassword(credentialsId: 'aws_admin', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
    	dir("$WORKSPACE/$path"){
    		writeFile file: 'terraform.tfvars', text: '''AWS_ACCESS_KEY = "''' + "$AWS_ACCESS_KEY_ID" +'''"
AWS_SECRET_KEY = ''' + "$AWS_SECRET_ACCESS_KEY" + '''
AWS_REGION = "us-east-1"'''
    	}
    }
}


def void initAndApply(String path){
	dir("$WORKSPACE/$path"){
		//updateProvider(path)
		sh "ls -lrt"
		withCredentials([usernamePassword(credentialsId: 'aws_admin', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
  		sh "export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID"
  		sh "export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY"
  		sh "export AWS_DEFAULT_REGION=us-east-1"
	
		sh "docker pull hashicorp/terraform:light"
	    sh "docker run -w /app  -v `pwd`:/app hashicorp/terraform:light init"
	   // withAWS(credentials: 'aws_admin', region: 'us-east-1') {
    		sh "docker run -w /app -v /root/.aws:/root/.aws -v `pwd`:/app hashicorp/terraform:light plan -var=\"AWS_ACCESS_KEY=$AWS_ACCESS_KEY_ID\" -var=\"AWS_SECRET_KEY=$AWS_SECRET_ACCESS_KEY\""
    		sh "docker run -w /app -v /root/.aws:/root/.aws -v `pwd`:/app hashicorp/terraform:light apply -auto-approve -var=\"AWS_ACCESS_KEY=$AWS_ACCESS_KEY_ID\" -var=\"AWS_SECRET_KEY=$AWS_SECRET_ACCESS_KEY\" -var=\"app_image=705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:${BUILD_NUMBER}\" ecs.tf"

}	    
	       
	}           
 }
 
 def void plan(String path){
	dir("$WORKSPACE/path"){
	    sh "terraform plan"   
	}           
 }
 
 def void apply(String path){
	dir("$WORKSPACE/path"){
	    sh "terraform apply"   
	}           
 }
 
 def void destroy(String path){
	dir("$WORKSPACE/path"){
	    sh "terraform destroy"   
	}           
 }
 


