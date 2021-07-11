From openjdk:8-jdk-alpine
MAINTAINER frutas4caro
COPY target/invoiceservice-and-controller-0.0.1-SNAPSHOT.jar invoiceservice-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/invoiceservice-0.0.1.jar"]