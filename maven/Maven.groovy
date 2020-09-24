def void build(){
        dir("$WORKSPACE"){
            sh "./mvnw clean package"
        }

    }
    
 def void runTest(){
         dir("$WORKSPACE"){
            sh "./mvnw clean test \"-Durl=${url}\""
        }
     }

