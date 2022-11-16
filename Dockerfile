FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} sportyshoes.jar

ENTRYPOINT ["java", "-jar", "/sportyshoes.jar"]

EXPOSE 9050