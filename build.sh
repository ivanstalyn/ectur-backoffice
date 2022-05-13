#!/bin/bash

docker container stop mysql_db
docker rm mysql_db
docker-compose up -d --build
