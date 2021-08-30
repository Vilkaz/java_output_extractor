#!/bin/bash

#first you have to build the artefact, for example gradle or mvn
#gradle clean build  or mvn clean build

#here you can get the values for deployment variables from secret store like parameter store as example
export REGION="eu-central-1"
serverless deploy