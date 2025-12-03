package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Flight;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlightDAO implements DAO {

    public static int flightsNum = 0;
    String[] flights = new String[flightsNum];

    public static ObservableList<Flight> viewFlights() {
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM flights";
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection
            ResultSet rs = stmt.executeQuery(); // Executes the SQL query and stores the result in a ResultSet
            while (rs.next()) {
                flights.add(new Flight(
                        rs.getInt("flightId");
                        rs.getInt("capacity");
                        rs.getInt("bookedSeats");
                        rs.getString("departureCity");
                        rs.getString("arrivalCity");
                        rs.getString("departureTime");
                        rs.getString("arrivalTime");
                ));
            }

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
        }
    }
}

//public void insertRecord(String firstName, String mi, String lastName, String email, String password, String
