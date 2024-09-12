# Spring Boot Cache Demo
This repository contains examples of how to use different caching solutions in a Spring Boot project. Each subproject implements a different caching solution to demonstrate its usage in Spring Boot-based applications.

## Caching with Spring Boot
Each subproject demonstrates a different way to use caching with Spring Boot. The goal is to illustrate how these technologies can be integrated to optimize the performance of applications that require repeated access to data that doesn't change frequently.
- Caffeine: Provides a high-performance in-memory cache.
- Hazelcast: Offers a distributed cache solution that also supports clustering.
- Redis: An in-memory key-value data store used for local caching purposes.

## Subprojects & Swagger UI Documentation
Each subproject demonstrates a different caching mechanism and includes an accessible API documentation via Swagger UI. You can click the links below to explore the APIs and learn more about each caching implementation.

| Cache Example          | Description                                                                                | Swagger UI URL                                                                                           |
|------------------------|--------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------|
| **Caffeine Example**   | Example of cache implementation using [Caffeine](https://github.com/ben-manes/caffeine).   | [http://localhost:8085/api/v1/swagger-ui/index.html](http://localhost:8085/api/v1/swagger-ui/index.html) |
| **Redis Example**      | Example of cache implementation using [Redis](https://redis.io/).                          | [http://localhost:8086/api/v1/swagger-ui/index.html](http://localhost:8086/api/v1/swagger-ui/index.html) |
| **Hazelcast Example**  | Example of cache implementation using [Hazelcast](https://hazelcast.com/).                 | [http://localhost:8087/api/v1/swagger-ui/index.html](http://localhost:8087/api/v1/swagger-ui/index.html) |

Feel free to experiment with the different caching mechanisms and see how they behave in real-time through the documented endpoints.

### Prerequisites
To run any of these examples, ensure you have the following installed:

- Java 17 or higher.
- Maven 3.6.x or higher.
- Docker (for the Redis example if you choose to run Redis in a container).

### Running Instructions

1. Clone the repository:
```bash
  git clone git@github.com:arianmtzcu/spring-boot-cache-demo.git
```

2. Navigate to the project directory you're interested in:
```bash
  cd spring-boot-caffeine-example
  # or 
  cd spring-boot-hazelcast-example
  # or 
  cd spring-boot-redis-example
```

3. Run the project using Maven:
```bash
  mvn spring-boot:run
```

4. (Optional) If you're running the Redis project, make sure you have a Redis instance running. You can use Docker to launch Redis easily:
```yml
version: '3.8'
services:
  redis:
    image: redis:latest
    container_name: redis
    ports:
      - "6379:6379"
    volumes:
      - redis-data:/data
    restart: always

  mysql:
    image: mysql:8.0
    container_name: mysql
    environment:
      MYSQL_DATABASE: userdb
      MYSQL_ROOT_PASSWORD: root
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql
    restart: always

volumes:
  redis-data:
  mysql-data:
```

Run the following command to start the services:
```bash
  docker-compose up -d
```

## Contributing
Contributions are welcome! If you have a feature or example you'd like to add, feel free to fork the repository, make your changes, and submit a pull request.

## License
This project is licensed under the [MIT License](https://opensource.org/license/MIT).