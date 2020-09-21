def void build(){
        dir("$WORKSPACE"){
            sh "./mvnw clean package"
        }

    }
