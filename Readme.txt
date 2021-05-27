README

The compose.yml file can be run to create a linked container. 


Frontend Location: /src/vuex_app
Frontend dockerfile: /src/vuex_app/Dockerfile
Port: 3000 (container and outer port)

Backend Spring Boot Location: /: root folder
Backend dockerfile: /Dockerfile

Mongodb's latest version has been downloaded and run directly. 

Mongodb has been configured as to adopt the following properties in line with the 
spring boot: 

spring.data.mongodb.database = ChannelPizza
spring.data.mongodb.authentication-database=ChannelPizza
spring.data.mongodb.username=pizzauser
spring.data.mongodb.password=12345

User needs to be created through mongo shell. The sample data is also in the /src/mongodb folder. 

