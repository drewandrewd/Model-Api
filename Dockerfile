FROM openjdk:9-jdk

WORKDIR /opt
COPY ./target /opt

RUN chmod 777 /opt/*

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/opt/education-model-api-0.0.1-SNAPSHOT.jar"]