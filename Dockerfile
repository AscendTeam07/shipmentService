FROM openjdk:8
VOLUME /tmp
EXPOSE 9602
ARG JAR_FILE=target/shipment-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} shipmentapp.jar
ENTRYPOINT ["java","-jar","/shipmentapp.jar"]