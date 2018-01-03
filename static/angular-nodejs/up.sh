#!/bin/bash

export $(cat ./../../.env | grep -v ^# | xargs)
npm start