#!/bin/sh
echo "Mysql container is running on port 3306:3306 by using the host system you can access the or you can go inside the container"
docker run --name mysql-container  -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=productdb -p 3306:3306 -d mysql:latest
