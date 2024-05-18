FROM maven:latest

# Set the working directory in the container
WORKDIR /app
# Copy the pom.xml file to the container
ENTRYPOINT [ "mvn","clean","package","-Pproduction" ]