#!/bin/bash
set -eu

cd backend-app

echo "==> Building backend-app"
mvn clean package -DskipTests 

echo "==> Done"
