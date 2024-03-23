FROM amazoncorretto:21-alpine
EXPOSE 8080
ENV GOOGLE_APPLICATION_CREDENTIALS ./firebase-config/service_account.json
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
