#!/bin/bash -xe

echo "[+] Building ..."

echo " | [+] Static ..."
pushd static/angular-nodejs
./build.sh
popd
echo " | [-] Static"

echo " | [+] Service ..."
pushd services/grizzly-jersey
./build.sh
popd
echo " | [-] Service"

echo "[-] Building"
