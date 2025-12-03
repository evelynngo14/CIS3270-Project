package dao;

import java.sql.*;

public class LoginDAO implements DAO {



    boolean verifyCredentials(String username, String password) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
        String sql = "SELECT user FROM users WHERE username = ? AND password = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        // query params
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        // check if username exists
        if (rs.next()) {
            return true;
        } else return false;

        } catch (SQLException e) {
            System.out.println("Error verifying credentials: " + e.getMessage());
            return false;
        }
    }
}
