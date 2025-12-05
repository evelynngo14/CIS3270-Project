package model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
    private static int flightId;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int capacity;
    private int bookedSeats;

    public Flight() {}

    public Flight(int flightId, String departureCity, String arrivalCity,
                  LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int capacity, int bookedSeats) {
        Flight.flightId = flightId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.capacity = capacity;
        this.bookedSeats = bookedSeats;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    @Override
    public String toString() {
        return "model.Flight " + flightId + ": " + departureCity + " → " + arrivalCity +
                "on" + " at " + departureDateTime.toString() + " to " + arrivalDateTime.toString() +
                " | Seats Available: " + getAvailableSeats();
    }

    public int getFlightId() {
        return flightId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }
}
