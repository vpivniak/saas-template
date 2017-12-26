#!/bin/bash

echo "[+] Building ..."

echo " | [+] Static ..."
pushd static/angular
npm i
npm run build
popd
echo " | [-] Static"

echo " | [+] Service ..."
pushd services/java
./build.sh
popd
echo " | [-] Service"

echo "[-] Building"
