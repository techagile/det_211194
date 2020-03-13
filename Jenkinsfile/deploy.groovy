#!groovy

properties([
        buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '30'))
        ])

def environmentDetails

pipeline {
  agent {
    label 'master'
  }

  options { 
    timestamps()
  }

  environment {
    GIT_BRANCH = 'windows_cut'
  }

  post {
        failure {
            updateGitlabCommitStatus(name: 'build', state: 'failed')
        }
        success {
            updateGitlabCommitStatus(name: 'build', state: 'success')
        }
  }

  stages {
    stage('Initialise') {
      steps {
        deleteDir()
        updateGitlabCommitStatus(name: 'build', state: 'pending')

	//console out ENV.VARS	
	sh 'printenv'
      }
    } 

    
  } // end of stages
} // end of pipeline

