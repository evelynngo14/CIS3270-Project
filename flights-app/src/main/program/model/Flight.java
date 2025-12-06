package model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Flight {
    private int flightId;
    private String departureCity;
    private String arrivalCity;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int capacity;
    private int bookedSeats;

    public Flight() {}

    public Flight(int flightId, String departureCity, String arrivalCity,
                  LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int capacity, int bookedSeats) {
        this.flightId = flightId;
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

    public void incrementCapacity() {
        capacity++;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
