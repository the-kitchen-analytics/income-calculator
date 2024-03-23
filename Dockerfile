FROM gradle:8.6.0-jdk21 as java-build

ARG APP_HOME=/home/gradle/src
WORKDIR $APP_HOME
COPY --chown=gradle:gradle . .
RUN gradle build -x test --no-daemon

ARG JAR_FILE=income-calculator-0.0.3.jar
ARG JAR_TARGET_DIR=/build/libs
ARG JAR=$APP_HOME$JAR_TARGET_DIR/$JAR_FILE

WORKDIR $APP_HOME/layers
RUN java -Djarmode=layertools -jar $JAR extract

FROM amazoncorretto:21-alpine as runtime

RUN mkdir /app
WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY --from=java-build /home/gradle/src/layers/dependencies/ ./
COPY --from=java-build /home/gradle/src/layers/spring-boot-loader/ ./
COPY --from=java-build /home/gradle/src/layers/snapshot-dependencies/ ./
COPY --from=java-build /home/gradle/src/layers/application/ ./

EXPOSE 8080
ENV GOOGLE_APPLICATION_CREDENTIALS /firebase-config/service_account.json

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
