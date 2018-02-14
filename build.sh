#!/bin/bash -xe

export $(cat ./.env | grep -v ^# | xargs)

echo "[+] Building ..."

echo " | [+] Static ..."
pushd static/angular-nodejs
#./build.sh
npm i
npm run build
popd
echo " | [-] Static"

echo " | [+] Service ..."
pushd services/grizzly-jersey
#./build.sh
mvn clean install
popd
echo " | [-] Service"

echo "[-] Building"
