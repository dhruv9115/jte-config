def void createTaskDefFile(){

	//sh "rm -f anagrams.json"
        writeFile file: 'anagrams.json', text: '''[
  {
    "name": "anagram",
    "image": '''+ "705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:${BUILD_NUMBER}" + ''',
    "cpu": 1024,
    "memory": 2048,
    "networkMode": "awsvpc",
    "logConfiguration": {
        "logDriver": "awslogs",
        "options": {
          "awslogs-group": "/ecs/anagrams",
          "awslogs-region": "us-east-1",
          "awslogs-stream-prefix": "ecs"
        }
    },
    "portMappings": [
      {
        "containerPort": 8080,
        "hostPort": 8080
      }
    ]
  }
]'''
        
    }
    
    
def String returnJson(){

	String json = '''[
  {
    "name": "anagram",
    "image": '''+ "705110607627.dkr.ecr.us-east-1.amazonaws.com/anagrams:${BUILD_NUMBER}" + ''',
    "cpu": 1024,
    "memory": 2048,
    "networkMode": "awsvpc",
    "logConfiguration": {
        "logDriver": "awslogs",
        "options": {
          "awslogs-group": "/ecs/anagrams",
          "awslogs-region": "us-east-1",
          "awslogs-stream-prefix": "ecs"
        }
    },
    "portMappings": [
      {
        "containerPort": 8080,
        "hostPort": 8080
      }
    ]
  }
]'''

	echo "$json"
	
	return json
        
    }

    
def void updateService(){
	
	//createTaskDefFile()
	
    withCredentials([usernamePassword(credentialsId: 'aws_admin', passwordVariable: 'AWS_SECRET_ACCESS_KEY', usernameVariable: 'AWS_ACCESS_KEY_ID')]) {  
    	String aws = "docker run --rm -e AWS_ACCESS_KEY_ID=$AWS_ACCESS_KEY_ID -e AWS_SECRET_ACCESS_KEY=$AWS_SECRET_ACCESS_KEY -e AWS_DEFAULT_REGION=us-east-1 -v `pwd`:/app amazon/aws-cli"
    	//sh "$aws ecs register-task-definition --family anagrams-task --cli-input-json " + returnJson()
    	/*String TASK_REVISION = sh (
    script: 'aws ecs describe-task-definition --task-definition anagrams-task | egrep "revision" | tr \"/\" \" \" | awk \'{print $2}\' | sed \'s/"$//\'',
    returnStdout: true
).trim()*/
        //sh "$aws ecs update-service --cluster anagram-cluster --service anagram-service --task-definition anagrams-task:${TASK_REVISION} --desired-count 2"
         sh "$aws ecs update-service --cluster anagram-cluster --service anagram-service --force-new-deployment"
    }
    }

