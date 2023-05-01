FROM openjdk:11-jdk-slim

RUN apt-get update && \
    apt-get install -y postgresql

COPY target/my-project.jar /app/my-project.jar

WORKDIR /app

EXPOSE 8080 5432

CMD ["service", "postgresql", "start"]
CMD ["java", "-jar", "/app/my-project.jar"]