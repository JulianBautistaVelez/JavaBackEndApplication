FROM openjdk:8
ADD target/api-taller-bautista.jar api-taller-bautista.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-taller-bautista.jar"]