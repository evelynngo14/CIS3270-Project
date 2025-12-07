package model;

import dao.BookingDAO;
import dao.FlightDAO;
import dao.RegistrationDAO;
import dao.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer extends User {

    protected int userId;

    BookingDAO bookingDAO = new BookingDAO();
    UserDAO userDAO = new UserDAO();
    RegistrationDAO registrationDAO = new RegistrationDAO();

    public Customer() {}

    public Customer(int userId) {
        this.userId = userId;
    }

    public boolean registerNewUser(String firstName, String lastName, String address, String zip,
                                   String state, String username, String password, String email,
                                   String ssn, String securityQuestion) {
        return registrationDAO.register(firstName, lastName, address, zip, state, username, password, email, ssn, securityQuestion);
    }

    public boolean bookFlight(int flightId, int userId, String seatNumber) {
        //return bookingDAO.insertBooking(flightId, userId, seatNumber);
        return false;
    }

    public boolean authenticateSsn(String ssn, String email, String username) {
        return (userDAO.verifySsn(ssn, username, email));
    }

    public boolean authenticateSecurityQuestion(String email, String ssn, String username) {
        return (userDAO.verifySecurityAnswer(username, email, ssn));
    }

    public ObservableList<Booking> getBookingsByUser() {
        return BookingDAO.getBookingsByUser(this.userId);
    }

    public void resetPassword(String username, String newPassword) {
        userDAO.updatePassword(username, newPassword);
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

    public int getUserId() {
        return this.userId;
    }

    public void searchFlights() {

    }

    public ObservableList<Flight> getAllFlights() {
        return FlightDAO.getFlights();
    }

    public boolean bookFlight(Flight flight) {
        return bookingDAO.insertBooking(flight.getFlightId(), userId);
    }
}
