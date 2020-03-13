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

  stages {
    stage('Initialise') {
      steps {
        deleteDir()

	//console out ENV.VARS	
	sh 'printenv'
      }
    } 

    
  } // end of stages
} // end of pipeline

