FROM openjdk:17
VOLUME ./tmp
EXPOSE 8080
ADD ./target/controle-financeiro-0.0.1-SNAPSHOT.jar controle.jar
ENTRYPOINT ["java","-jar","/controle.jar"]