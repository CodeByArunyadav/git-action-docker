FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY demo-git_action-docker/target/springboot_githubaction_demo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]