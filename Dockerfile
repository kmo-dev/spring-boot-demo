FROM springci/graalvm-ce:java17-0.11.x

ARG JAR_FILE=target/app.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]