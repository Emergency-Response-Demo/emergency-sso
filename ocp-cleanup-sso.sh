#!/usr/bin/env bash

oc project naps-emergency-response
oc delete all --selector app=sso73-x509-postgresql-persistent
oc delete configmap sso-config
oc delete pvc sso-postgresql-claim
oc delete bc/sso73-openshift-theme
oc delete is/sso73-openshift-theme
