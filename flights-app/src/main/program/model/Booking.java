package model;

import java.time.LocalDateTime;

public class Booking {

    protected int bookingId;
    protected int userId;
    protected int flightId;
    protected LocalDateTime bookingDateTime;
    protected String seatNumber;

    protected Flight flight;

    public Booking(int bookingId, int userId, int flightId, LocalDateTime bookingDateTime, String seatNumber, Flight flight) {
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getBookingId() {
        return bookingId;
    }
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureCity() {
        return flight.getDepartureCity();
    }

    public LocalDateTime getDepartureDateTime() {
        return flight.getDepartureDateTime();
    }

    public String getArrivalCity() {
        return flight.getArrivalCity();
    }

}
