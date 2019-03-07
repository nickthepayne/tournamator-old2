#!/bin/bash

if [[ -f .env ]]; then
    source .env
fi

echo "DEPLOY_ENV is set to ${DEPLOY_ENV}"

SPRING_PROFILE="${DEPLOY_ENV:-default}"

echo "Using Spring Profile: ${SPRING_PROFILE}"

java -Dspring.profiles.active=${SPRING_PROFILE} -jar app.jar