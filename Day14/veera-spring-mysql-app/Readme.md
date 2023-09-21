#Build

mvn clean install

# Run
```
docker-compose -f docker-compose-mysql.yml up -d

mvn spring-boot:run

```
## Creating docker image

```
mvn install dockerfile:build

```
## running docker compose

``` 
docker-compose up -d

```


## Post

``` 
curl --request POST 'http://localhost:8083/customer/create' --header 'Content-Type: application/json' --data-raw '{"name": "Rama","custId": "1re206","address": "Bangalore"}'
```

## Get

``` 
curl -X GET http://localhost:8083/customer/read 
```

## Put

``` 
curl --location --request PUT 'http://localhost:8081/hospital/update?hid=2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "hid":"2",
    "hospitalname":"san",
    "address":"rjy"

}'
```

## Delete

```
curl --location --request DELETE 'http://localhost:8083/hospital/delete?hospitalname=abc' 
```


## Getting inside container

docker exec -it 5e13bb7a4a38 /bin/bash
mysql -u user -p
show databases;
show tables;
select * from hospital;


## Stop docker container
    docker-compose -f docker-compose-mysql.yml down


### Maven
Here i am using maven spotify plugin to create the docker image for this application.
Use the below command to create the docker image.
For creating please use your repository to create the image which will be easy to push image in your docker hub.
update in your pom.xml.
<docker.image.prefix> <your repo name> </docker.image.prefix>

```bash
$ mvn install dockerfile:build
```

### Push docker images

```bash
docker login

$ docker push <repository-name>/<app-name>

docker push veera005/veera-spring-mysql-app 
```
