package dao;

import java.sql.*;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Booking;
import model.Flight;

public class BookingDAO implements DAO {

    // needed for departure/arrival times and cities
    private static Flight mapResultSetToFlight(ResultSet rs) throws SQLException {
        LocalDateTime departureDateTime = rs.getTimestamp("departureDateTime").toLocalDateTime();
        LocalDateTime arrivalDateTime = rs.getTimestamp("arrivalDateTime").toLocalDateTime();

        return new Flight(
                rs.getInt("flightId"),
                rs.getString("departureCity"),
                rs.getString("arrivalCity"),
                departureDateTime,
                arrivalDateTime,
                rs.getInt("capacity"),
                rs.getInt("bookedSeats")
        );
    }

    public static ObservableList<Booking> getBookingsByUser(int userId) {
        ObservableList<Booking> bookings = FXCollections.observableArrayList();

        // b. = bookings table | f. = flights table
        String query =
                "SELECT b.*, f.departureCity, f.arrivalCity, f.departureDateTime, f.arrivalDateTime, f.capacity, f.bookedSeats " +
                        "FROM bookings b JOIN flights f ON b.flightId = f.flightId " +
                        "WHERE b.userId = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            PreparedStatement stmt =  conn.prepareStatement(query);
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Flight flight =  mapResultSetToFlight(rs);
                LocalDateTime bookingDateTime = rs.getTimestamp("bookingDateTime").toLocalDateTime();

                bookings.add(new Booking(
                        rs.getInt("bookingId"),
                        rs.getInt("userId"),
                        rs.getInt("flightId"),
                        bookingDateTime,
                        rs.getString("seatNumber"),
                        flight
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error viewing booking: " + e.getMessage());
        }
        return bookings;
    }

    public void insertBooking(int flightId, int userId, String seatNumber) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "INSERT INTO bookings (flightId, userId, seatNumber) VALUES (?, ?, ?)" +
                    "UPDATE flights SET bookedSeats = bookedSeats + 1 WHERE flightId = ?;";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, flightId);
            stmt.setInt(2, userId);
            stmt.setString(3, seatNumber);
            stmt.setInt(4, flightId);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error inserting booking: " + e.getMessage());
        }
    }
}
