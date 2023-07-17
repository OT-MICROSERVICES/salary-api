<p align="center">
  <img src="./static/salary-api-logo.svg" height="300" width="300">
</p>

Salary API is a Java based microservice which is responsible for all the salary related transactions and records in **[OT-Microservices](https://github.com/OT-MICROSERVICES)** stack. The application is platform independent and can be run on multiple operating system. **[Java Runtime](https://www.java.com/en/download/manual.jsp)** would be required to run this application.

Supported features of the Salary API are:-

- Spring boot based web framework, which uses tomcat as webserver.
- ScyllaDB is used as primary database for storing all the salary data.
- Redis as cache manager to store the cache response.
- Prometheus and Open-telemetry metrics support for monitoring and observability
- Swagger integration for the API documentation of endpoints and payloads.
- Database migration using the tool called **[migrate](https://github.com/golang-migrate/migrate)**.

## Pre-Requisites

The Salary API application have some database, cache manager and package dependencies. Some of the dependencies are optional and some are mandatory. To compile the application, we only need `maven` as build tool, but for running the application following things are required:-

- **[ScyllaDB](https://www.scylladb.com/)**
- **[Redis](https://redis.io/)**
- **[Migrate](https://github.com/golang-migrate/migrate)**
- **[Maven](https://maven.apache.org/)**

Maven will be used as package manager to download specific version of dependencies to run the Salary API.

## Architecture

![](./static/salary.png)
