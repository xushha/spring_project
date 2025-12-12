FROM eclipse-temurin:17-jdk-focal AS builder


WORKDIR /app


COPY build.gradle settings.gradle gradlew ./

COPY gradle ./gradle


COPY src ./src


RUN chmod +x gradlew


RUN ./gradlew bootJar -x test

FROM eclipse-temurin:17-jre-focal


WORKDIR /app

EXPOSE 8080

COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]