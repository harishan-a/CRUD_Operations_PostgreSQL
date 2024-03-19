# Student Information Management System
This Java application demonstrates CRUD (Create, Read, Update, Delete) operations on a PostgreSQL database managing student information. It includes setup instructions for the PostgreSQL database using pgAdmin and steps to compile and run the Java application.
Name: Harishan Amutheesan
StudentID: 101154757

### Application Functions
- View Initial Data: Retrieves and displays all student records.
- Add a New Student: Inserts a new student record into the database.
- Update a Student's Email: Updates the email address for a specified student ID.
- Delete a Student: Removes a student record based on student ID.

## Database Setup

### Install PostgreSQL and pgAdmin

1. Download and install PostgreSQL from [the official site](https://www.postgresql.org/download/). Note your `postgres` user password.
2. pgAdmin is included with PostgreSQL and provides a graphical interface for database management.

### Create the Database

1. Open pgAdmin and connect to your PostgreSQL server.
2. Right-click on "Databases" and select "Create" > "Database...".
3. Name the database `student_info` and save.

### Create the Students Table

With the `student_info` database selected, open the Query Tool and execute:

```sql
CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    enrollment_date DATE
);

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

```

## Application Setup

The system comprises three primary files: 
- `DBConnectionConfig.java` for database connection management
- `AppFunctions.java` for defining CRUD operations
- `Main.java` for executing the application.

### Prerequisites

- Java JDK 11 or newer.
- PostgreSQL JDBC Driver (handled by Maven).

### Configure Database Connection

In `DBConnectionConfig.java`, ensure the database connection details are correct:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/student_info";
private static final String USER = "postgres";
private static final String PASSWORD = "your_password";
```
Replace '"your_password"' with your actual PostgreSQL password.

### Compile and Run the Application

**Compilation**: Navigate to the project directory in the terminal and compile the Java files using `javac` or through your IDE.

**Execution**: Run the `Main` class to start the application:

```shell
java Main
```



