# ---------- Builder Stage ----------
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /workspace

COPY pom.xml .
RUN mvn -B -q dependency:go-offline

COPY src ./src
RUN mvn -B -q clean package -DskipTests

# ---------- Runtime Stage ----------
FROM alpine:3.18

LABEL authors="Opstree Solution" \
      contact="opensource@opstree.com" \
      version="v0.1.0" \
      service="salary-api"

# Install only JRE (smaller & safer)
RUN apk add --no-cache openjdk17-jre

# Create non-root user
RUN addgroup -S app && adduser -S app -G app

WORKDIR /app

COPY --from=builder /workspace/target/salary-0.1.0-RELEASE.jar /app/salary.jar

RUN chown -R app:app /app

USER app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/salary.jar"]
