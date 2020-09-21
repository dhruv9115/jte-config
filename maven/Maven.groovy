def void build(){
        dir("$WORKSPACE/${JOB_NAME}"){
            sh "./mvnw clean package"
        }

    }
