FROM openjdk:17
WORKDIR /app

COPY target/springboot_githubaction_demo.jar springboot_githubaction_demo.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "springboot_githubaction_demo.jar"]
