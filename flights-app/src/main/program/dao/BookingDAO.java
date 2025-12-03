package dao;

import java.sql.*;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.

public class BookingDAO implements DAO {
    public static ObservableList<Booking> getAllBookings() {
        ObservableList<Booking> bookings = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM booking");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                LocalDateTime bookingDateTime = rs.getTimestamp("bookingDateTime").toLocalDateTime();

                bookings.add(new Booking(
                        rs.getInt("bookingId"),
                        rs.getInt("userId"),
                        rs.getInt("flightId"),
                        bookingDateTime,
                        rs.getString("seatNumber")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
            String query = "INSERT INTO bookings (flightId, userId, seatNumber) VALUES (?, ?, ?)" +
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
