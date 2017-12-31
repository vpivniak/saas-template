#!/bin/bash

echo "[+] Building ..."

echo " | [+] Static ..."
pushd static/angular
./build.sh
popd
echo " | [-] Static"

echo " | [+] Service ..."
pushd services/java
./build.sh
popd
echo " | [-] Service"

echo "[-] Building"
