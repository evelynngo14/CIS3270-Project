package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Flight;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;

/*
7 COLUMNS:
flightId
departureCity
arrivalCity
departureDateTime
arrivalDateTime
capacity
bookedSeats
 */

public class FlightDAO implements DAO {

    public static int flightsNum = 0;
    String[] flights = new String[flightsNum];

    public static ObservableList<Flight> getFlights() {
        // Observable list is used as source for TableView
        ObservableList<Flight> flights = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM flights";
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection
            ResultSet rs = stmt.executeQuery();  // Executes the SQL query and stores the result in a ResultSet

            // iterate through rs to create instances of flights and populate with flight data
            while (rs.next()) {
                // convert LocalDateTime for compatibility with ResultSet
                LocalDateTime departureDateTime = rs.getTimestamp("departureDateTime").toLocalDateTime();
                LocalDateTime arrivalDateTime = rs.getTimestamp("arrivalDateTime").toLocalDateTime();

                flights.add(new Flight(
                        rs.getInt("flightId"),
                        rs.getString("departureCity"),
                        rs.getString("arrivalCity"),
                        departureDateTime,
                        arrivalDateTime,
                        rs.getInt("capacity"),
                        rs.getInt("bookedSeats")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error fetching flight data: " + e.getMessage());
        }

        return flights;
    }

    public static boolean addFlight(Flight newFlight) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "INSERT INTO flights (departureCity, arrivalCity, departureDateTime, arrivalDateTime, capacity, bookedSeats) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, newFlight.getDepartureCity());
            stmt.setString(2, newFlight.getArrivalCity());
            stmt.setTimestamp(3, Timestamp.valueOf(newFlight.getDepartureDateTime()));
            stmt.setTimestamp(4, Timestamp.valueOf(newFlight.getArrivalDateTime()));
            stmt.setInt(5, newFlight.getCapacity());
            stmt.setInt(6, newFlight.getBookedSeats());
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error adding flight: " + e.getMessage());
            return false;
        }
    }

    public static boolean deleteFlight(int flightId) {
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "DELETE FROM flights WHERE flightId = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, flightId);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error deleting flight: " + e.getMessage());
        }
        return false;
    }

    //public static boolean searchFlight(String departureCity, String arrivalCity, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {}

}