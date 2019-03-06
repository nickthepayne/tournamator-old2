FROM gradle:5.2.1-jdk8

ADD tournamator-app/build/libs/tournamator-app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]