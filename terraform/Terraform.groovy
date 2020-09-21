def void init(String path){
	dir("$WORKSPACE/path"){
	    sh "terraform init"   
	}           
   }
