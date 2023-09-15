# Build

    mvn clean install

# Run
    docker-compose -f docker-compose-rabbitmq.yml up -d
    veera-rabbitmq-app-producer> mvn spring-boot:run

# Test

##post 

curl --location --request POST 'http://localhost:8080/rabbitmq/hospital' \
--header 'Content-Type: application/json' \
--data-raw '{
"hid":"12345",
"hname":"prime",
"address":"kkp"

}'


##patient

curl --location --request POST 'http://localhost:8080/rabbitmq/patient/' \
--header 'Content-Type: application/json' \
--data-raw '{
"pid":"9876",
"pname": "hhhh",
"disease":"xxx"
}'


##get

curl --location --request GET 'http://localhost:8080/rabbitmq/hproducer?hid=123499&hname=san&address=rjy'


##patient

curl --location --request GET 'http://localhost:8080/rabbitmq/patproducer?pid=9876&pname=hhhh&disease=xxx'


 veera-rabbitmq-app-consumer> mvn spring-boot:run

# Show data on browser::

    http://localhost:15672/

    user-name:guest
    password:guest


## Stop Container

    docker-compose -f docker-compose-rabbitmq.yml down