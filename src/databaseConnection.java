
// Import necessary classes for database connection and handling exceptions
import java.sql.Connection; // Represents a connection to a database
import java.sql.SQLException; // Handles SQL-related exceptions
import javax.swing.JOptionPane; // Used to display dialog boxes to the user
import java.sql.DriverManager; // Manages database drivers and establishes connections

/**
 * This class is designed to establish a connection to a MySQL database.
 */
public class databaseConnection {
    // Constants for database connection details
    final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC driver class
    final static String DB_URL = "jdbc:mysql://localhost:3306/student"; // Database URL, connecting to 'student' database
    final static String USER = "root"; // Username for the database connection
    final static String PASS = ""; // Password for the database connection (empty string here)

    /**
     * Establishes a connection to the database.
     * @return a Connection object if successful, or null if an error occurs.
     */
    public static Connection connection() {
        try {
            // Load the JDBC driver class to ensure it's available for the connection
            Class.forName(JDBC_DRIVER);

            // Attempt to establish a connection to the database using the specified URL, username, and password
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Return the connection object if successful
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            // Display an error message in a dialog box if the driver class is not found or a SQL exception occurs
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            // Return null to indicate that the connection was unsuccessful
            return null;
        }
    }
}
