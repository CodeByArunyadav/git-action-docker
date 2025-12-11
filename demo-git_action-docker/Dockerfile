FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/springboot_githubaction_demo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
