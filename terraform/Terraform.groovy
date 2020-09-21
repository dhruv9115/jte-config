def void init(String path){
tool name: 'Terraform', type: 'terraform'
	dir("$WORKSPACE/path"){
	    sh "terraform init"   
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
 


