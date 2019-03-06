#!/bin/sh

set -e

echo ${GCLOUD_SERVICE_KEY} > ${HOME}/gcp-key.json
gcloud auth activate-service-account --key-file ${HOME}/gcp-key.json
gcloud --quiet config set project ${GCLOUD_PROJECT_ID}
gcloud config set compute/zone ${GCLOUD_COMPUTE_ZONE}
