# ![Javalin Maven DInject Template](docs/javalin-logo.png)
> ### Javalin Maven DInject Template

Built with **Javalin + Kotlin + Javalin + DInject**

# Getting started

You need just JVM installed. (`jdk8`)

The server is configured to start on [`localhost:8080/${project.context}`](http://localhost:8080/change-me-to-context) 
with `project.context` context, you can change in `application.properties`.

Build:
> mvn clean install

Login docker registry
> docker login -u="$USERNAME" -p="$USER_PASSWORD" docker-repository

Package & Generate Docker Image
> mvn package -DskipTests=true docker:build

Run via docker-composer
> docker-compose up

