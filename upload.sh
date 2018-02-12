#!/bin/bash

export $(cat ./.env | grep -v ^# | xargs)

GROUP_ID=$1 #com.swecourse.services
ARTIFACT_ID=$2 #api
BUNDLE_VERSION=$3 #18.2.0-SNAPSHOT
BUNDLE_PACKAGING="jar"
ARTIFACT="${GROUP_ID}.${ARTIFACT_ID}-${BUNDLE_VERSION}.${BUNDLE_PACKAGING}"
PATH_TO=$4 #./services/grizzly-jersey/target

echo "Upload artifact ${ARTIFACT} into Nexus snapshot repository"

mvn --settings ./settings.xml deploy:deploy-file \
  -DrepositoryId=${NEXUS_REPO} \
  -Durl="${NEXUS_HOST}/repository/${NEXUS_REPO}" \
  -Dfile="${PATH_TO}/${ARTIFACT}" \
  -DgroupId="${GROUP_ID}" \
  -DartifactId="${ARTIFACT_ID}" \
  -Dversion="${BUNDLE_VERSION}" \
  -Dpackaging="${BUNDLE_PACKAGING}" \
  -DgeneratePom=true \
  -DuniqueVersion=false
