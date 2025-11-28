package dao;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlightDAO {
    private static final String url = "mysql -h cis3270db.mysql.database.azure.com -P 3306 -u cis3270db -p";
    private static final String dbUser = "src/main/cis3270db";
    private static final String dbPass = "Administrator!";
    int flightsNum = 0;
    String[] flights = new String[flightsNum];

    public static void viewFlights() {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM flights";
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection
            ResultSet rs = stmt.executeQuery(); // Executes the SQL query and stores the result in a ResultSet

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
    }
}
//public void insertRecord(String firstName, String mi, String lastName, String email, String password, String
