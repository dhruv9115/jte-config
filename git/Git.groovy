def clone_repo(){  
    git 'https://github.com/dhruv9115/generate_anagram.git'
    sh "ls -lrt"
    sh "pwd"
}


def clone_test_repo(){  
    git 'https://github.com/dhruv9115/generate_anagram-test.git'
    sh "ls -lrt"
    sh "pwd"
}