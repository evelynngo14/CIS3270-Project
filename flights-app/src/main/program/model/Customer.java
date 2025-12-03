package model;

import dao.BookingDAO;
import dao.FlightDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer extends User {

    protected int userId;

    BookingDAO bookingDAO = new BookingDAO();

    public Customer(String username, String password, String email) {
        super(username, password, email);
    }

    public boolean bookFlight(int flightId, int userId, String seatNumber) {
        bookingDAO.insertBooking(flightId, userId, seatNumber);
        return false;
    }

    public ObservableList<Booking> getBookingsByUser() {
        return BookingDAO.getBookingsByUser(this.userId);
    }

    @Override
    public String getRole() {
        return "customer";
    }
}
