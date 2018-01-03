#!/bin/bash

export $(cat ./../../.env | grep -v ^# | xargs)
java -jar target/service-17.11.0-SNAPSHOT-jar-with-dependencies.jar