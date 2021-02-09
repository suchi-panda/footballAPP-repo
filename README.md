## FOOTBALL API
This is a springboot based microservice to find standings of a team playing league football match using country name, league name and team name. The
service is accessible via web browser on internet and end user should be able to view results by changing previously listed parameters. Output of
this service is presented in web browser using any one of Javascript framework, HTML or JSON and  the service is ready to be released
to production or live environment.

### Prerequisite

Installed:
JDK 1.8
Maven 3
Docker
git
jenkin


### For building and running the application you need:

JDK 1.8
Maven 3


### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.football.demo.FootBallApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

Once the application is up, you can access the below application url to find standings of a team playing league football match using country name, league name and team name.

### Application URL

http://localhost:8085/v1/football/countries/England/leagues/Championship/teams/Brentford

you can view results by changing previously listed parameters.

Data is fetched consuming APIFooball APIs available @ https://apifootball.com/documentation/

### Steps to run build docker image and run the contnairazation ->

Build Docker image 
docker build -f Dockerfile -t football-image .

Run Docker Container
docker run -p 8085:8085 football-image

Then test the application accessing the below url ->

http://localhost:8085/v1/football/countries/England/leagues/Championship/teams/Brentford

### Steps to configure the jenkin ->

Add pipiline following below steps  ->
select pipiline script from SCM.
In SCM select Git, and in repositories, add repository URL as https://github.com/suchi-panda/footballAPP-repo.git and credentials. 
Specify the branch as */master then save it.
Provide the Script Path -> Jenkinfile.
Then click on build now in dashboard and this will follow the steps mentioned in jenkin file and buils will succeed.


