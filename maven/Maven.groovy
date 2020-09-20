def void build(){
        directory("$WORKSPACE/${JOB_NAME}"){
            sh "mvn clean install"
        }

    }
