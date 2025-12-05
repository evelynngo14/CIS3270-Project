package dao;

import model.User;
import java.sql.*;

public class UserDAO implements DAO {

    public void viewFlights() {
    }


    // customer specific
    public void deleteBooking(int bookingId) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM bookings WHERE bookingId = ?" );
            stmt.setInt(1, bookingId);
        } catch (SQLException e) {
            System.out.println("Error deleting booking: " + e.getMessage());
        }
    }

    // used for forgot password in Login Model
    public boolean verifySecurityAnswer(String username, String email, String securityQuestion) {
        String query = "SELECT securityAnswer FROM users WHERE username = ? AND securityQuestion = ? AND email = ?";
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, securityQuestion);
            stmt.setString(3, email);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;

        } catch (SQLException e) {
            System.out.println("Error authenticating security answer: " + e.getMessage());
        }
        return false;
    }

    public boolean verifySsn (String ssn, String username, String email) {
        String query = "SELECT ssn FROM users WHERE username = ? AND ssn = ? AND email = ?";
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, ssn);
            stmt.setString(3, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {
            System.out.println("Error authenticating SSN: " + e.getMessage());
        }
        return false;
    }

    public void updatePassword(String username, String password) {
        String query = "UPDATE users SET password = ? WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, password);
            stmt.setString(2, username);
            stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error updating password: " + e.getMessage());
        }
    }
}

