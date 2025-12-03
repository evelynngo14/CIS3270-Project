package model;

import dao.BookingDAO;
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

    @Override
    public String getRole() {
        return "customer";
    }
}
