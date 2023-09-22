## Build the app

``` 
mvn clean install
```

## Run the app

``` 
docker-compose -f docker-compose-mongo.yml up -d

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

## prescriptionController

curl --location 'http://localhost:9090/saveprescription' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic ZG9jdG9yMDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=83E66BEDB3E13C97A2F8F9510CB618DD' \
--data '{
"prescriptionId": "pre1001",
"appointmentId":"app999001",
"description":"fever and cough",
"patientName":"Lusi",
"doctorName":"Sandhya"
}'

## DoctorController


curl --location 'http://localhost:9090/doctor/save' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic ZG9jdG9yMDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=83E66BEDB3E13C97A2F8F9510CB618DD' \
--data '{
"appointmentId":"app999001",
"patientName":"Lusi",
"doctorName":"Sandhya",
"date":"25/09/2023",
"prescription":{
"prescriptionId": "pre1001",
"appointmentId":"app999001",
"description":"fever and cough",
"patientName":"Lusi",
"doctorName":"Sandhya"
}
}'

## PatientController

curl --location 'http://localhost:9090/patient/save' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic ZG9jdG9yMDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=83E66BEDB3E13C97A2F8F9510CB618DD' \
--data '{
"appointmentId":"app999001",
"patientName":"Lusi",
"doctorName":"Sandhya",
"date":"25/09/2023",
"prescription":{
"prescriptionId": "pre1001",
"appointmentId":"app999001",
"description":"fever and cough",
"patientName":"Lusi",
"doctorName":"Sandhya"
}
}'

--------------------------------


## Get

## prescriptionController

curl --location --request POST 'http://localhost:9090/viewprescription?patientName=Lusi' \
--header 'Authorization: Basic ZG9jdG9yMDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=83E66BEDB3E13C97A2F8F9510CB618DD' \
--data ''


## DoctorController

curl --location --request POST 'http://localhost:9090/patient/myappointments?patientName=Lusi' \
--header 'Authorization: Basic ZG9jdG9yMDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=83E66BEDB3E13C97A2F8F9510CB618DD' \
--data ''

## PatientController

curl --location --request POST 'http://localhost:9090/doctor/doctorappointment?doctorName=Sandhya' \
--header 'Authorization: Basic ZG9jdG9yMDE6cGFzc3dvcmQ=' \
--header 'Cookie: JSESSIONID=83E66BEDB3E13C97A2F8F9510CB618DD' \
--data ''



## Show data

```
docker exec -it <Containername> bash/bin

mongo

show dbs

Use data

show tables

db.prescription.find()

db.appointment.find()

## Stop docker container
    docker-compose -f docker-compose-mongo.yml down


