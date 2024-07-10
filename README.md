# Hoen Scanner

Hoen Scanner is a microservice developed to assist users in finding car rentals and hotels in the Hoen Archipelago. This microservice is built using the Dropwizard framework.

## Table of Contents

- [Overview](#overview)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Service](#running-the-service)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Overview

Hoen Scanner processes HTTP requests to provide relevant search results based on input data. It integrates with the Skyscanner backend to search through provided files for matches and respond with any hotels and rental car services found.

## Installation

To set up the project locally, follow these steps:


1. **Build the project using Maven:**

    ```sh
    mvn clean install
    ```

2. **Ensure you have Java 11 or higher installed.**

## Configuration

The configuration file for Dropwizard is `config.yml`. This file includes server settings and other necessary configurations.

## Running the Service

To start the service, run the following command:

```sh
java -jar target/hoen-scanner-1.0-SNAPSHOT.jar server config.yml



The service will start on the default port (8080) and admin port (8081).

## API Endpoints

### Car Rentals

* **GET** `/search/car_rentals`
   * **Description:** Retrieves a list of car rentals in a specified city.
   * **Parameters:** `city` (query parameter)
   * **Example:**

     ```sh
     curl -X GET "http://localhost:8080/search/car_rentals?city=shaleport"
     ```

* **POST** `/search/car_rentals`
   * **Description:** Retrieves a list of car rentals based on JSON input.
   * **Body:** JSON object with `city` field.
   * **Example:**

     ```sh
     curl -X POST "http://localhost:8080/search/car_rentals" -H "Content-Type: application/json" -d '{"city": "shaleport"}'
     ```

### Hotels

* **GET** `/search/hotels`
   * **Description:** Retrieves a list of hotels in a specified city.
   * **Parameters:** `city` (query parameter)
   * **Example:**

     ```sh
     curl -X GET "http://localhost:8080/search/hotels?city=rustburg"
     ```

* **POST** `/search/hotels`
   * **Description:** Retrieves a list of hotels based on JSON input.
   * **Body:** JSON object with `city` field.
   * **Example:**

     ```sh
     curl -X POST "http://localhost:8080/search/hotels" -H "Content-Type: application/json" -d '{"city": "rustburg"}'
     ```

## Testing

To test the service, you can use tools like Postman or CURL to make requests to the endpoints and verify the responses.
