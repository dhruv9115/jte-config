def void build(){
        dir("$WORKSPACE"){
            sh "./mvnw clean package"
        }

    }
    
 def void test(){
         dir("$WORKSPACE"){
            sh "./mvnw clean test \"-Durl=${url}\""
        }
     }

