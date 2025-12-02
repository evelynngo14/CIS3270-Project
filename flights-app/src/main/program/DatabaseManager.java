package scene_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // this overlaps with DAO.java
    private static final String URL = "jdbc:mysql://cis3270db.mysql.database.azure.com:3306/airline_reservation?useSSL=true";
    private static final String USER = "src/main/cis3270db";
    private static final String PASS = "Administrator!";

    // this method actually tries to open a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // this method is just for testing. It checks if we can connect.
    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("Connected to the database successfully!");
            return true;     // connection worked
        } catch (SQLException e) {
            System.out.println("Could not connect: " + e.getMessage());
            return false;    // connection failed
        }
    }
}
