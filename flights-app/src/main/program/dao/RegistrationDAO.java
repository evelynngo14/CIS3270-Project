package dao;

import java.sql.*;

public class RegistrationDAO implements DAO {

    public static boolean register(String firstName, String lastName, String address, String zip,
                                   String state, String username, String password, String email,
                                   String ssn, String securityQuestion) {

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)){
            String query = "INSERT INTO users (firstName, lastName, address, zip, state, username, password, email, ssn, securityQuestion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.setString(4, zip);
            stmt.setString(5, state);
            stmt.setString(6, username);
            stmt.setString(7, password);
            stmt.setString(8, email);
            stmt.setString(9, ssn);
            stmt.setString(10, securityQuestion);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error inserting user" + e.getMessage());
            return false;
        }
    }
}