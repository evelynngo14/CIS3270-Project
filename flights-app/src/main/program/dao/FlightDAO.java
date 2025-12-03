package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Flight;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class FlightDAO implements DAO {

    public static int flightsNum = 0;
    String[] flights = new String[flightsNum];

    public static ObservableList<Flight> getFlights() {
        // Observable list is used as source for TableView
        ObservableList<Flight> flights = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM flights";
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection
            ResultSet rs = stmt.executeQuery(); // Executes the SQL query and stores the result in a ResultSet

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
            System.out.println("Error fetching flight data: " + e.getMessage());
        }

        return flights;
    }
}

//public void insertRecord(String firstName, String mi, String lastName, String email, String password, String
