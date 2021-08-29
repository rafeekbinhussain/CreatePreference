FROM openjdk:11
COPY ./build/libs/preference-0.0.1-SNAPSHOT.jar preference-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","preference-0.0.1-SNAPSHOT.jar"]
VOLUME /tmp
EXPOSE 8082
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
