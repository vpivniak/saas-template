#!/bin/bash

envFile="./.env"

if [ -f "$envFile" ]
then
  . $envFile

  # [+] service
  pushd services/grizzly-jersey
  export GJ_ARTIFACT=$(mvn -q -Dexec.executable="echo" -Dexec.args='${project.artifactId}-${project.version}-jar-with-dependencies.${project.packaging}' --non-recursive org.codehaus.mojo:exec-maven-plugin:1.3.1:exec)
  popd
  # [-] service

  docker-compose up $1

else
  echo "'$envFile' not found."
  echo "copy '.env.template' to '$envFile' and update it according to your environment"
fi

