package dao;

import java.sql.*;

public class RegistrationDAO {

    private static String url = "jdbc:mysql://cis3270db.mysql.database.azure.com:3306/airline_reservation?useSSL=true";
    private static String dbUser = "src/main/cis3270db";
    private static String dbPass = "Administrator!";

    // simple method to add a user
    public static boolean register(String username, String email, String password) {
        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPass);

            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);

            int result = stmt.executeUpdate();

            conn.close();
            return result == 1;

        } catch (SQLException e) {
            System.out.println("Error while registering user");
            return false;
        }
    }
}
