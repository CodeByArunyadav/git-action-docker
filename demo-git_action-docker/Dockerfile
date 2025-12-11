FROM eclipse-temurin:17-jdk-slim-buster

WORKDIR /app

COPY target/springboot_githubaction_demo.jar springboot_githubaction_demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/springboot_githubaction_demo.jar"]
