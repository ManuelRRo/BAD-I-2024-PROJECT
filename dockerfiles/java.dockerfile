FROM openjdk:21-jdk

ARG JAR_FILE=target/*.jar

WORKDIR /code

ENTRYPOINT [ "java","-jar","/code/target/biblioteca-0.0.1-SNAPSHOT.jar" ]
