# MontrealHockeyTeam
A web application to add and get players information of Montreal Canadiens Hockey team

## Data Base 
For DB, postgresql is used, to work with **pgAdmin 4** is a solution<br/>
(https://www.pgadmin.org/download/) <br/>
In (MontrealHockeyTeam/hockeyteamBackend/src/main/resources/application.properties) You need to update : <br/>
> spring.datasource.url=jdbc:postgresql://localhost:5432/<YOUR DB NAME> <br/>
> spring.datasource.username=YOUR DB USERNAME <br/>
> spring.datasource.password=YOUR DB PASSWORD <br/>

## Backend
For Backend side, spring boot framework (**2.7.2**) is used <br/>
with **jdk-17.0.4+8** java version <br/>
#### How to use
to start server use : ./mvnw spring-boot:run

## Frontend
For Frontend side, **Angular 13** version is used <br/>
#### How to use
to start server use : ng serve
