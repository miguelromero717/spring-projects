# RabbitMQ Spring Example

This is a simple example to communicate two services through RabbitMQ.

You can run the project on local and over Docker.

* [Publish Microservice](publish-ms/README.md)
* [Subscribe Microservice](subscribe-ms/README.md)

## Requirements

To run over docker

* [Docker](https://www.docker.com/)
* [docker-compose](https://docs.docker.com/compose/)

To run locally. To see local endpoints go to each project.

* [Docker](https://www.docker.com/)
* [docker-compose](https://docs.docker.com/compose/)
* [Java 11](https://www.oracle.com/co/java/technologies/javase/jdk11-archive-downloads.html)

## Getting Started

1. Clone project
2. Go to project root and run `docker-compose up --build -d`

## Docker endpoints

* Publish
POST - `http://localhost:8880/api/publish/{value}`

* Subscribe
GET - `http://localhost:8881/api/subscribe`

## Author

Miguel Romero