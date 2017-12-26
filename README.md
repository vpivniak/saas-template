# Software Engineering Course project template
* Clone https://github.com/swe-course/content.git with helpers
* Execute
  ```
  > ./prereq.sh docker
  > ./prereq.sh maven
  > ./prereq.sh nodejs
  > ./prereq.sh jenkins
  ```
  * Run http://<host>:8080 and complete Jenkins installation
  * Install SonarQube using sonarqube/README.md
  * Install Nexus
  * Configure Jenkins using jenkins/README.md

# API
curl -v -X POST -H "Content-Type: application/json" -d"{}" http://46.101.7.84/api/v1/contacts
