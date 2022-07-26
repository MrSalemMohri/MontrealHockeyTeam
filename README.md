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
To start server use : ./mvnw spring-boot:run
#### Code
Controller :
  * PlayerController : 
    * createPlayer (Create new player and add it in a team that specified by year)
    * updatePlayer (Update Captain of team, with playerId)
  * TeamController : 
    * getAllTeam (retrieve all teams and show it in Team page)
    * listPlayersTeam (retrieve all players of searched team and show it in Team search result page)<br/>
  
Services : 
  * PlayerService, TeamService (Database operations for the different player and team api)    
  * DataBaseStructInitializer (Initialize Database with creating all sequence and tables if doesn't already exist)<br/>
  
DTO (Data Transfer Objects) are used to avoid infinite loops when we retrive players and teams<br/>
Throw Exception doesn't used in classes, in the best case it's necessary to create and use global exception handlers, <br/>
  here we just use EntityNotFoundException in some cases
  
## Frontend
For Frontend side, **Angular 13** version is used <br/>
#### How to use
To initialize the project use (npm install) in Frontend folder<br/>
To start server use : ng serve
#### Code
Components
  * Add Player Component :<br/>
  Add player front end page, this component used to add player and it works with addPlayerForTeamByYear (team service)
  * Team List Component :<br/>
  This Component List all teams in database on first Team frontend page and it works woth getAll (team service)
  * Team Details Component : :<br/>
  This Component shows team searched by year and it works with getTeamByYear service
  
