#!/bin/bash
export $(cat ./../../.env | grep -v ^# | xargs)
npm i
npm run build
