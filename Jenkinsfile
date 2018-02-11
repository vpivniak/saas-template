node {
  //
  def pullRequest = false
  def repo = ''
  def org = ''
  def groupId = ''
  def artifactId = ''
  def version = ''
  //
  echo "SONARQUBE_SERVER: ${SONARQUBE_SERVER}"
  echo "SONARQUBE_SCANNER: ${SONARQUBE_SCANNER}"
  echo "SONARQUBE_ACCESS_TOKEN: ${SONARQUBE_ACCESS_TOKEN}"
  echo "NEXUS_REPOSITORY: ${NEXUS_REPOSITORY}"
  echo "SERVICE_PORT: ${SERVICE_PORT}" 
  
  stage('Clone sources') {
    //
    def scmVars = checkout scm
    if (params.containsKey('sha1')){
      pullRequest = true
      echo "Pull request build sha1: ${sha1}"
      sh "git fetch --tags --progress origin +refs/pull/*:refs/remotes/origin/pr/*"
      sh "git checkout ${ghprbActualCommit}"
    } else {
      echo "Build push branch: ${scmVars.GIT_BRANCH}, sha: ${scmVars.GIT_COMMIT}"
      sh "git checkout ${scmVars.GIT_COMMIT}"
    }
    echo sh(returnStdout: true, script: 'env')
    //
    dir ('service') {
      groupId = sh(returnStdout: true, script:'''mvn help:evaluate -Dexpression=project.groupId | grep -e "^[^\\[]"''').trim()
      artifactId = sh(returnStdout: true, script:'''pushd bundle > /dev/null && mvn help:evaluate -Dexpression=project.artifactId | grep -e "^[^\\[]" && popd > /dev/null''').trim()
      version = sh(returnStdout: true, script:'''mvn help:evaluate -Dexpression=project.version | grep -e "^[^\\[]"''').trim()
    }
    echo "groupId: ${groupId} artifactId: ${artifactId} version: ${version}"
    //
    repo = sh(returnStdout: true, script:'''git config --get remote.origin.url | rev | awk -F'[./:]' '{print $2}' | rev''').trim()
    org = sh(returnStdout: true, script:'''git config --get remote.origin.url | rev | awk -F'[./:]' '{print $3}' | rev''').trim()
    echo "org: ${org} repo: ${repo}"
  } 
  
  
  /*/
  //
  //sh '''cat ./.env'''
  //
  echo sh(returnStdout: true, script: 'env')
  stage('Build & Unit tests') {
    //sh './build.sh'
  }
  /*/
  /*/
  stage('SonarQube analysis') {
    def scannerHome = tool "${SONARQUBE_SCANNER}";
    withSonarQubeEnv("${SONARQUBE_SERVER}") {
      if (pullRequest){
        //sh "${scannerHome}/bin/sonar-scanner -X -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=${ghprbPullId} -Dsonar.github.repository=${org}/${repo} -Dsonar.github.oauth=${GITHUB_ACCESS_TOKEN} -Dsonar.login=${SONARQUBE_ACCESS_TOKEN}"
      } else {
        sh "${scannerHome}/bin/sonar-scanner"
      }
    }
  }
  /*/
  stage('Deploy & Publish') {
    if (pullRequest){
    } else {
      //sh './upload.sh'
    }
    //archiveArtifacts artifacts: 'mobile/platforms/android/build/outputs/apk/*.apk'
  }
  stage('Cleanup') {
    echo 'Cleanup'
  }
}
