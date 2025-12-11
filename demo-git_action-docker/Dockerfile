FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/springboot_githubaction_demo.jar springboot_githubaction_demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/springboot_githubaction_demo.jar"]
