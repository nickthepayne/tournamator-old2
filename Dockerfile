FROM gradle:5.2.1-jdk8

ADD tournamator-app/build/libs/tournamator-app.jar app.jar
ADD .env .env
ADD deploy/docker-entrypoint.sh entrypoint.sh

USER root

RUN chmod +x entrypoint.sh

EXPOSE 8080

ENTRYPOINT ["./entrypoint.sh"]