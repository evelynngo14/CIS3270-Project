package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingDAO implements DAO {

    public void viewBooking(int userId) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            // b. = bookings table | f. = flights table
            PreparedStatement stmt =
                    conn.prepareStatement(
                            "SELECT b.bookingId, b.bookingDate, b.seatNumber, f.departureCity, " +
                                    "f.arrivalCity, f.departureDateTime " +
                                    "FROM bookings b" +
                                    "JOIN flights f ON b.flightId = f.flightId " +
                                    "WHERE b.userId = ?"
                    );
            stmt.setInt(1, userId);

        } catch (SQLException e) {
            System.out.println("Error viewing booking: " + e.getMessage());
        }
    }

    public void insertBooking(int flightId, int userId, int seatNumber) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "INSERT INTO bookings (flightId, userId, bookedSeats) VALUES (?, ?, ?)" +
                    "UPDATE flights SET bookedSeats = bookedSeats + 1 WHERE flightId = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, flightId);
            stmt.setInt(2, userId);
            stmt.setInt(3, seatNumber);
            stmt.setInt(4, flightId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting booking: " + e.getMessage());
        }
    }
}
