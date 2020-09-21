def void init(String path){
	dir("$WORKSPACE/path"){
		withCredentials([usernamePassword(credentialsId: 'aws_admin', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {
  		sh "export AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID"
  		sh "export AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY"
  		sh "export AWS_DEFAULT_REGION=us-east-1"
}	
		sh "docker pull hashicorp/terraform:light"
	    sh "docker run hashicorp/terraform:light init"   
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
 


