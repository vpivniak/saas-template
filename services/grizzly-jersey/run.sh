#!/bin/bash

export $(cat ./../../.env | grep -v ^# | xargs)
java -jar target/service-18.2.0-SNAPSHOT-jar-with-dependencies.jar