import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class is responsible for managing the database connection.
 */
public class DBConnectionConfig {
    // The URL of the database to connect to.
    private static final String URL = "jdbc:postgresql://localhost:5432/student_info";
    // The username to use when connecting to the database.
    private static final String USER = "postgres";
    // The password to use when connecting to the database.
    private static final String PASSWORD = "postgres";
    // A flag indicating whether a successful connection to the database has been established.
    private static boolean isConnected = false;

    /**
     * This method is used to establish a connection to the database.
     * It prints a success message upon the first successful connection.
     * @return A Connection object if the connection is successful, null otherwise.
     */
    public Connection connection() {
        try {
            // Attempt to establish a connection to the database.
            Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);
            // If this is the first successful connection, print a success message.
            if (!isConnected) {
                System.out.println("Connected to the database successfully.");
                isConnected = true;
            }
            // Return the established connection.
            return connect;
        } catch (Exception e) {
            // If an error occurs, print the error message and return null.
            System.out.println(e.getMessage());
            return null;
        }
    }
}