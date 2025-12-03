package dao;

import model.User;
import java.sql.*;

public class UserDAO implements DAO {

    public void viewFlights() {
    }


    public void deleteBooking(int bookingId) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM bookings WHERE bookingId = ?" );
            stmt.setInt(1, bookingId);
        } catch (SQLException e) {
            System.out.println("Error deleting booking: " + e.getMessage());
        }
    }
}

