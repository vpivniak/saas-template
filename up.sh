#!/bin/bash

export $(cat ./.env | grep -v ^# | xargs)

envFile="./.env"

# [+] service
pushd services/grizzly-jersey
export SERVICES_GJ_ARTIFACT=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}-${project.version}-jar-with-dependencies.${project.packaging}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec)
popd
# [-] service

docker-compose up $1
