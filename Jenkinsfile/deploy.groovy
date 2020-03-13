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

    stage('Clone DETMonitor') {
      steps {
        dir("${JOB_BASE_NAME}") {
          checkout([$class                 : 'GitSCM',
          branches                         : [[name: "origin/${GIT_BRANCH}"]],
          doGenerateSubmoduleConfigurations: false,
          extensions                       : [[$class: 'RelativeTargetDirectory', relativeTargetDir: "det_211194"]],
          submoduleCfg                     : [],
          userRemoteConfigs                : [[credentialsId: '1be88572-8d8e-4440-8509-45092b8a4885',
          refspec: '+refs/heads/master:refs/remotes/origin/master',
          url: "https://github.com/techagile/det_211194.git"]]])
        } // end of dir
      } // end of steps
    } // end of stage


    stage('Deploy DETMonitor') {
      steps{
        dir("${JOB_BASE_NAME}/det_211194") {
          withCredentials([usernamePassword(credentialsId: '909c520d-dccb-4541-a724-22cedac2f935', passwordVariable: 'OPS_PASSWORD', usernameVariable: 'OPS_USERNAME')]) {
	    script {
              try {
                sh('ansible-playbook -i hosts custom_monitor.yml -u cloud_user -e "ansible_ssh_user=${OPS_USERNAME} ansible_ssh_pass=${OPS_PASSWORD} ansible_become_pass=${OPS_PASSWORD}" -vvvv')  
              } catch(e) {
                echo "Deploy DETMonitor stage failed!" 
              } finally {
                echo "Good so far!"
              } // end of finally
            } // end of script
          } // end of withCredentials
	} // end of dir
      } // end of steps
    } // end of stage
  } // end of stages
} // end of pipeline

