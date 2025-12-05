package model;

import dao.BookingDAO;
import dao.FlightDAO;
import dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer extends User {

    protected int userId;

    BookingDAO bookingDAO = new BookingDAO();
    UserDAO userDAO = new UserDAO();

    public Customer() {}

    public Customer(int userId) {
        this.userId = userId;
    }

    public boolean bookFlight(int flightId, int userId, String seatNumber) {
        bookingDAO.insertBooking(flightId, userId, seatNumber);
        return false;
    }

    public boolean authenticateSsn(String ssn, String email, String username) {
        return (userDAO.verifySsn(ssn, username, email));
    }

    public boolean authenticateSecurityQuestion(String email, String ssn, String username) {
        return (userDAO.verifySecurityAnswer(email, ssn, username));
    }

    public ObservableList<Booking> getBookingsByUser() {
        return BookingDAO.getBookingsByUser(this.userId);
    }

    //public ObservableList<Flight> searchFlights() {
        // return
        // call FlightDAO (get flights based on a SQL query)
        // (SELECT from flight where city is ___ and time ___)
    //}

    @Override
    public String getRole() {
        return "customer";
    }
}
