#!/bin/bash
set -eu

cd backend-app

echo "==> Building frontend-app"
mvn clean package -DskipTests

echo "==> Done"
