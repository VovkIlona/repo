#!/bin/bash
# Docker script

rm -rf lab6-dir

docker container stop lab6-container
docker container stop mysql-container

docker container rm lab6-container
docker container rm mysql-container

docker image rm lab6-img

echo "Clonning lab from github..."
mkdir lab6-dir

cd lab6-dir/
git clone "https://github.com/VovkIlona/repo.git"

echo "Running mysql container..."
docker run -d -p 3306:3306 --name mysql-container -v mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=Ilona_db mysql

echo "Creating jar files..."
cd repo
mvn install clean package


echo "Building image of spring application..."
docker build -t lab6-img .

echo "Running spring application container..."
docker run -p 8080:8080 --name lab6-container --link mysql-container:mysql lab6-img | grep ERROR


rm -rf ../../lab6-dir
echo "Done"

