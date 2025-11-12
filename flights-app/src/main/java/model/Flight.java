package model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private int flightId;
    private String departureCity;
    private String destinationCity;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int capacity;
    private int bookedSeats;

    public boolean login(String inputUsername, String inputPassword) {
        String url = "jdbc:mysql://cis3270db.mysql.database.azure.com:3306/airline_reservation?useSSL=true";
        String dbUser = "cis3270db";
        String dbPass = "Administrator!";


        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM flights"; // ? is filled with user's input
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection

            ResultSet rs = stmt.executeQuery(); // Executes the SQL query and stores the result in a ResultSet
            if (rs.next()) {
                //this.username = rs.getString("username");
                //this.password = rs.getString("password");
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Invalid credentials.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public Flight(int flightId, String departureCity, String destinationCity, LocalDate departureDate,
                  LocalTime departureTime, LocalTime arrivalTime, int capacity, int bookedSeats) {
        this.flightId = flightId;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.bookedSeats = bookedSeats;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    @Override
    public String toString() {
        return "model.Flight " + flightId + ": " + departureCity + " → " + destinationCity +
                " on " + departureDate + " at " + departureTime +
                " | Seats Available: " + getAvailableSeats();
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
