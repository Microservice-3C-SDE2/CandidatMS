FROM eclipse-temurin:17
COPY target/Candidat-0.0.1-SNAPSHOT.jar candidat.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","candidat.jar"]

