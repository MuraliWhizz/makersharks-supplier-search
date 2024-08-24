# makersharks-supplier-search
# Supplier Search API

## Description

The Supplier Search API is a RESTful API developed for the Makersharks project. It provides endpoints to manage and search for suppliers, including batch operations for creating and updating supplier records.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Requirements](#requirements)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Testing](#testing)
- [License](#license)

## Features

- **CRUD Operations**: Create, Read, Update, and Delete supplier records.
- **Batch Operations**: Support for creating multiple suppliers in a single request.
- **Search**: Query suppliers based on location, nature of business, and manufacturing processes.

## Technologies Used

- **Spring Boot**: Framework for building the RESTful API.
- **Spring Data JPA**: For data access and management with MySQL.
- **MySQL**: Database for storing supplier data.
- **H2 Database**: In-memory database for testing purposes.
- **JUnit and Mockito**: For testing.

## Requirements

- **Java**: JDK 17
- **Maven**: 3.8.x or later
- **MySQL**: 8.0 or later
- **Spring Boot**: 2.7.13
- **IDE**: An Integrated Development Environment (IDE) such as IntelliJ IDEA, Eclipse, or VS Code (optional)

## Setup and Installation

1. **Clone the Repository**

    ```bash
    git clone https://github.com/MuraliWhizz/makersharks-supplier-search
    cd suppliersearch
    ```

2. **Configure Application Properties**

   - Create a `src/main/resources/application.properties` file with your database configuration:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. **Build the Project**

    ```bash
    mvn clean install
    ```

4. **Run the Application**

    ```bash
    mvn spring-boot:run
    ```

   The application will start on `http://localhost:8080`.

## Usage

You can interact with the API using HTTP methods via tools like [Postman](https://www.postman.com/) or `curl`.

### Endpoints

1. **Get Suppliers**

    ```http
    GET /api/supplier
    ```

    **Parameters:**
    - `location` (optional): Filter suppliers by location.
    - `natureOfBusiness` (optional): Filter suppliers by nature of business.
    - `manufacturingProcess` (optional): Filter suppliers by manufacturing process.

2. **Get All Suppliers**

    ```http
    GET /api/supplier/query
    ```

3. **Create a Supplier**

    ```http
    POST /api/supplier
    ```

    **Request Body:**

    ```json
    {
        "company_name": "BMW",
        "website": "https://www.bmw.com",
        "location": "Global",
        "nature_of_business": "SMALL_SCALE",
        "manufacturing_processes": ["THREE_D_PRINTING", "CASTING"]
    }
    ```

4. **Update a Supplier**

    ```http
    PUT /api/supplier/{id}
    ```

    **Request Body:**

    ```json
    {
        "company_name": "BMW",
        "website": "https://www.bmw.com",
        "location": "Global",
        "nature_of_business": "SMALL_SCALE",
        "manufacturing_processes": ["THREE_D_PRINTING", "CASTING"]
    }
    ```

5. **Create Multiple Suppliers**

    ```http
    POST /api/supplier/batch
    ```

    **Request Body:**

    ```json
    [
        {
            "company_name": "BMW",
            "website": "https://www.bmw.com",
            "location": "Global",
            "nature_of_business": "SMALL_SCALE",
            "manufacturing_processes": ["THREE_D_PRINTING", "CASTING"]
        },
        {
            "company_name": "Roye",
            "website": "https://www.roye.com",
            "location": "India",
            "nature_of_business": "SMALL_SCALE",
            "manufacturing_processes": ["CASTING", "COATING"]
        }
    ]
    ```

## Testing

Run tests using Maven:

```bash
mvn test

## Endpoints

### Query Suppliers

- **URL**: `/api/supplier/query`
- **Method**: `POST`
- **Description**: Retrieve a list of manufacturers based on specific criteria, including location, nature of business, and manufacturing process.

#### Request

**Content-Type**: `application/json`

**Request Body**:

```json
{
    "location": "India",
    "natureOfBusiness": "SMALL_SCALE",
    "manufacturingProcess": "THREE_D_PRINTING",
    "page": 0,
    "size": 10
}


#Folder Structure 


├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── makersharks
│   │   │           └── searchapi
│   │   │               ├── config
│   │   │               │   └── SecurityConfig.java
│   │   │               ├── controller
│   │   │               │   └── SupplierController.java
│   │   │               ├── dto
│   │   │               │   ├── SupplierQueryDTO.java
│   │   │               │   └── SupplierResponseDTO.java
│   │   │               ├── entity
│   │   │               │   ├── ManufacturingProcess.java
│   │   │               │   ├── NatureOfBusiness.java
│   │   │               │   └── Supplier.java
│   │   │               ├── exception
│   │   │               │   └── ResourceNotFoundException.java
│   │   │               ├── repository
│   │   │               │   └── SupplierRepository.java
│   │   │               ├── service
│   │   │               │   └── SupplierService.java
│   │   │               └── SupplierSearchApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── target
│       └── maven-archiver
│           └── pom.properties
└── target
    ├── classes
    │   ├── application.properties
    │   └── com
    │       └── makersharks
    │           └── searchapi
    │               ├── config
    │               │   └── SecurityConfig.class
    │               ├── controller
    │               │   └── SupplierController.class
    │               ├── dto
    │               │   ├── SupplierQueryDTO.class
    │               │   └── SupplierResponseDTO.class
    │               ├── entity
    │               │   ├── ManufacturingProcess.class
    │               │   ├── NatureOfBusiness.class
    │               │   └── Supplier.class
    │               ├── exception
    │               │   └── ResourceNotFoundException.class
    │               ├── repository
    │               │   └── SupplierRepository.class
    │               ├── service
    │               │   └── SupplierService.class
    │               └── SupplierSearchApplication.class
    ├── generated-sources
    │   └── annotations
    ├── maven-archiver
    │   └── pom.properties
    ├── maven-status
    │   └── maven-compiler-plugin
    │       └── compile
    │           └── default-compile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── suppliersearch-0.0.1-SNAPSHOT.jar
    └── suppliersearch-0.0.1-SNAPSHOT.jar.original

