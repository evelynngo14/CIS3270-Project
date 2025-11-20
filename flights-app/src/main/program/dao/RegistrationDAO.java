package dao;

import java.sql.*;

    public RegistrationDAO() {
        // match the connection constants used in UserDAO in this repo
        private static final String url = "jdbc:mysql://cis3270db.mysql.database.azure.com:3306/airline_reservation?useSSL=true";
        private static final String dbUser = "src/main/cis3270db";
        private static final String dbPass = "Administrator!";

        /**
         * Register a new user (simple: username, email, password).
         * Returns true if insert succeeds, false if username/email already exists or on error.
         */
        public static boolean register(String username, String email, String password) {
            if (existsByUsername(username) || existsByEmail(email)) {
                return false;
            }

            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, username);
                ps.setString(2, email);
                ps.setString(3, password);

                int rows = ps.executeUpdate();
                return rows == 1;
            } catch (SQLException e) {
                System.err.println("Registration failed: " + e.getMessage());
                return false;
            }
        }

        public static boolean existsByUsername(String username) {
            String sql = "SELECT 1 FROM users WHERE username = ? LIMIT 1";
            try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, username);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            } catch (SQLException e) {
                System.err.println("existsByUsername failed: " + e.getMessage());
                return false;
            }
        }

        public static boolean existsByEmail(String email) {
            String sql = "SELECT 1 FROM users WHERE email = ? LIMIT 1";
            try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass);
                 PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, email);
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            } catch (SQLException e) {
                System.err.println("existsByEmail failed: " + e.getMessage());
                return false;
            }
        }
}
