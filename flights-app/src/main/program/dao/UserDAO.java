package dao;

import model.User;

import java.sql.*;

public class UserDAO {
    private static final String url = "jdbc:mysql://cis3270db.mysql.database.azure.com:3306/airline_reservation?useSSL=true";
    private static final String dbUser = "cis3270db";
    private static final String dbPass = "Administrator!";

    // Authenticate user
    public static User login(String inputUsername, String inputPassword) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?"; // ? is filled with user's input

        // Establish the connection
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            // holds SQL query with parameters filled in
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection

            stmt.setString(1, inputUsername); // corresponds to ? according to parameter index
            stmt.setString(2, inputPassword);

            // Run the SQL query defined in stmt, and store the results in a ResultSet object called rs (table of rows)
            ResultSet rs = stmt.executeQuery(); // rs is handle to result set; use to loop through rows
            if (rs.next()) { // true if user exists
            }

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return null;
    }

}

