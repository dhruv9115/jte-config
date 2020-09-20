def void build(){
        dir("$WORKSPACE/${JOB_NAME}"){
            sh "mvn clean install"
        }

    }
