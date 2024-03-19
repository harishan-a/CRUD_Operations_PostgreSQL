import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * This class contains methods for performing CRUD operations on the students table in the database.
 */
public class AppFunctions {
    // An instance of DBConnectionConfig to manage the database connection.
    private DBConnectionConfig linked = new DBConnectionConfig();

    /**
     * This method retrieves all students from the students table and prints them.
     */
    public void getAllStudents() {
        // The SQL query to retrieve all students.
        String query = "SELECT * FROM students ORDER BY student_id";
        try (
                // Establish a connection to the database.
                Connection connect = linked.connection();
                // Create a statement for executing the SQL query.
                Statement statement = connect.createStatement();
                // Execute the SQL query and get the result set.
                ResultSet resultSet = statement.executeQuery(query)
        ) {
            // Print the header of the table.
            System.out.printf("%-5s %-10s %-10s %-30s %-10s%n", "ID", "First Name", "Last Name", "Email", "Enroll Date");
            System.out.println("---------------------------------------------------------------------------------");

            // Iterate through the result set and print each row.
            while (resultSet.next()) {
                System.out.printf("%-5d %-10s %-10s %-30s %-10s%n",
                        resultSet.getInt("student_id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getDate("enrollment_date").toString());
            }
            // Print a blank line for better separation between operations.
            System.out.println();
        } catch (Exception e) {
            // Print the error message if an exception occurs.
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method adds a new student to the students table.
     * @param firstName The first name of the new student.
     * @param lastName The last name of the new student.
     * @param email The email of the new student.
     * @param enrollmentDate The enrollment date of the new student.
     */
    public void addStudent(String firstName, String lastName, String email, String enrollmentDate) {
        // The SQL query to add a new student.
        String query = String.format("INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES ('%s', '%s', '%s', '%s')",
                firstName, lastName, email, enrollmentDate);
        try (
                // Establish a connection to the database.
                Connection connect = linked.connection();
                // Create a statement for executing the SQL query.
                Statement statement = connect.createStatement()
        ) {
            // Execute the SQL query.
            statement.executeUpdate(query);
            // Print a success message.
            System.out.println("Student added successfully.");
        } catch (Exception e) {
            // Print the error message if an exception occurs.
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method updates the email of a student in the students table.
     * @param studentId The ID of the student.
     * @param newEmail The new email of the student.
     */
    public void updateStudentEmail(int studentId, String newEmail) {
        // The SQL query to update the email of a student.
        String query = String.format("UPDATE students SET email = '%s' WHERE student_id = %d", newEmail, studentId);
        try (
                // Establish a connection to the database.
                Connection connect = linked.connection();
                // Create a statement for executing the SQL query.
                Statement statement = connect.createStatement()
        ) {
            // Execute the SQL query.
            statement.executeUpdate(query);
            // Print a success message.
            System.out.println("Email updated successfully.");
        } catch (Exception e) {
            // Print the error message if an exception occurs.
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method deletes a student from the students table.
     * @param studentId The ID of the student to be deleted.
     */
    public void deleteStudent(int studentId) {
        // The SQL query to delete a student.
        String query = String.format("DELETE FROM students WHERE student_id = %d", studentId);
        try (
                // Establish a connection to the database.
                Connection connect = linked.connection();
                // Create a statement for executing the SQL query.
                Statement statement = connect.createStatement()
        ) {
            // Execute the SQL query.
            statement.executeUpdate(query);
            // Print a success message.
            System.out.println("Student deleted successfully.");
        } catch (Exception e) {
            // Print the error message if an exception occurs.
            System.out.println(e.getMessage());
        }
    }
}