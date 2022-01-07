# Calculator Microservice

This is a Springboot project that exposes in a microservice a Rest api.

The Rest API have a unique endpoint: 


```GET /api/basic-operation/{operator}?op1={op1}&op2={op2}```


that allows two kind of operations: 
- addition (operator = ``add``)
- subtraction (operator = ``sub``)

## Libraries Used

- Spring Boot 2.6.2
- Spring Boot Test (JUnit 5 and Mockito)
- Model mapper 3.0.0
- Lombok
- Jacoco 0.7.7.201606060606

## Features
Calculator basic operations
- **Addition** of two big decimal numbers
- **Subtraction** of two big decimal numbers

## Decisions

- Writing integration tests and unit tests before writing code trying to follow the TDD philosophy.
- Creating an Operator enum and taking it as parameter in the controller to limit the 
  kind of operations the user can do, with another operation the rest api returns a 
  bad request, because of that there are not Exceptions or testing for invalid operations.
- Creating operations as beans with a base abstract class (Operation) to implement with polymorphism 
  the method calculate on each operation (Addition, Subtraction).
- Associating in the enum the class of each operation to be able to instantiate the specific class of the
  operation dynamically with reflection in the service layer. 
- When a new operation will need to be created only it is necessary to create the specific bean of the operation
  and to add this operation to the enum.
  

## Installing and execution

To install, compile and package a jar artifact it is necessary execute the following
commands in a console:

```
git clone https://github.com/luismls86/calculator.git
cd calculator
./mvnw clean package
java -jar ./target/calculator-1.0.0-SNAPSHOT.jar
```

## Rest API
The rest API will be deployed in port 8080.

If the microservice is deployed in localhost the url will be:

```http://localhost:8080/api/basic-operation/{operator}?op1={op1}&op2={op2}```


### Basic operation endpoint
The basic operation endpoint could take different values in {operator}

```GET /api/basic-operation/{operator}?op1={op1}&op2={op2}```



#### Addition

```GET /api/basic-operation/add?op1={op1}&op2={op2}```

Example:

```GET http://localhost:8080/api/basic-operation/add?op1=14.755&op2=21.35```

**Result body**

```
36.105
```



#### Subtraction
```GET /api/basic-operation/sub?op1={op1}&op2={op2}```

Example:

```GET http://localhost:8080/api/basic-operation/sub?op1=6.32&op2=5```

**Result body:**

```
1.32
```

#### Other operations
```GET /api/basic-operation/other?op1={op1}&op2={op2}```

Example:

```GET http://localhost:8080/api/basic-operation/other?op1=6.32&op2=5```

**Result body:**

```
{
    "status": 400,
    "error": "Bad Request"
}
```

## Testing and coverage report

To execute the unitary and integration tests it is necessary to execute the following 
command in a console:

```
mvn test
```

To generate the coverage report it is necessary to execute the following command in
a console:

```
mvn verify
```

The resulting report will be in:

```
./target/site/jacoco/index.html
```

## Versions
- 1.0.0-SNAPSHOT: Contains Creation of project and basic operations (addition, subtraction).

