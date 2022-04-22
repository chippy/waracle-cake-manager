# Java 11
FROM adoptopenjdk/openjdk11:alpine-jre

# Jar File
ARG JAR_FILE=target/cakemanager-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]