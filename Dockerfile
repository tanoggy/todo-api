FROM --platform=linux/amd64 maven:3.8.5-jdk-11 AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package -DskipTests

# Second stage: minimal runtime environment
From --platform=linux/amd64 openjdk:8u332-jre-buster

# copy jar from the first stage
COPY --from=builder target/*.jar my-app-1.0-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "my-app-1.0-SNAPSHOT.jar"]