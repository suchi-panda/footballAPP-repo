From openjdk:8
ADD target/spring-boot-docker-maven.jar spring-boot-docker-maven.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-boot-docker-maven.jar"]