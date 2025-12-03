package model;

import dao.BookingDAO;
import javafx.collections.ObservableList;
import model.Booking;
import java.sql.Connection;
import java.sql.DriverManager;

public class Customer extends User {

    public Customer(String username, String password, String email) {
        super(username, password, email);
    }

    public ObservableList<Flight> getAvailableFlights() {
    }

    public ObservableList<Booking> getBookings() {
    }

    public boolean bookFlight(int flightId, int userId, String seatNumber) {
        BookingDAO bookingDAO = new BookingDAO();
        bookingDAO.insertBooking(flightId, userId, seatNumber);
    }

    @Override
    public String getRole() {
        return "customer";
    }
}
