
Prerequisite

Installed:
JDK 1.8
Maven 3
Docker
git
jenkin


For building and running the application you need:

JDK 1.8
Maven 3


Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.football.demo.FootBallApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

Once the application is up, you can access the below url to find standings of a team playing league football match using country name, league name and team name.

http://localhost:8085/v1/football/countries/England/leagues/Championship/teams/Brentford

you can view results by changing previously listed parameters.

Data is fetched consuming APIFooball APIs.

Steps to run build docker image and run the contnairazation ->

Build Docker image 
docker build -f Dockerfile -t football-image .

Run Docker Container
docker run -p 8085:8085 football-image

Then test the application accessing the below url ->

http://localhost:8085/v1/football/countries/England/leagues/Championship/teams/Brentford

Steps to configure the jenkin ->


