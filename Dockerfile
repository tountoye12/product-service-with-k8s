
FROM openjdk:17-jdk-alpine
EXPOSE 8080

COPY target/*.jar  springboot-k8s-practice.jar

ENTRYPOINT ["java", "-jar", "/springboot-k8s-practice.jar"]
