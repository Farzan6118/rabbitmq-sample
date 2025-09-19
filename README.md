# RabbitMQ Sample Project

This is a sample modular project demonstrating **RabbitMQ messaging** with Spring Boot. The project is split into **Publisher** and **Subscriber** modules, showcasing how to send and receive messages asynchronously.

## Modules

### 1. Publisher

* Sends messages to a RabbitMQ exchange.
* Configurable routing keys.
* Demonstrates simple message creation and publishing.

### 2. Subscriber

* Listens to queues bound to the exchange.
* Processes incoming messages.
* Supports multiple subscribers for the same message.

## Features

* Modular structure for Publisher and Subscriber.
* RabbitMQ integration using Spring Boot AMQP.
* Easily extendable for more complex message types.
* Example of request-response or fire-and-forget messaging patterns.

## Getting Started

### Prerequisites

* Java 17+
* Spring Boot 3.x
* RabbitMQ server running locally or in Docker

### Running RabbitMQ with Docker

```bash
docker run -d --hostname my-rabbit --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

### Running the Project

1. Start the RabbitMQ server.
2. Run the **Publisher** module to send messages.
3. Run the **Subscriber** module to receive messages.

## Configuration

* Configure RabbitMQ host, exchange, and queue details in `application.yml` or `application.properties`.
* Example:

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

## How It Works

1. **Publisher** sends a message to a defined exchange.
2. RabbitMQ routes the message to the appropriate queue(s) based on routing keys.
3. **Subscriber** listens to the queue and processes messages asynchronously.

## Extending the Project

* Add more modules for different message types.
* Implement advanced routing with multiple exchanges and queues.
* Integrate with other Spring Boot services.

## Author

Farzan Saketi – [GitHub](https://github.com/Farzan6118)

## License

This project is open-source and available under the MIT License.
