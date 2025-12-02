package model;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class Flight {
    private int flightId;
    private String departureCity;
    private String arrivalCity;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int capacity;
    private int bookedSeats;

    public Flight(int flightId, String departureCity, String arrivalCity, LocalDate departureDate,
                  LocalTime departureTime, LocalTime arrivalTime, int capacity, int bookedSeats) {
        this.flightId = flightId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
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
        return "model.Flight " + flightId + ": " + departureCity + " → " + arrivalCity +
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

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
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
