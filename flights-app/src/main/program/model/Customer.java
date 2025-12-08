package model;

import dao.BookingDAO;
import dao.FlightDAO;
import dao.RegistrationDAO;
import dao.UserDAO;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Customer extends User {

    BookingDAO bookingDAO = new BookingDAO();
    UserDAO userDAO = new UserDAO();
    RegistrationDAO registrationDAO = new RegistrationDAO();

    public Customer() {}

    public boolean registerNewUser(String firstName, String lastName, String address, String zip,
                                   String state, String username, String password, String email,
                                   String ssn, String securityQuestion) {
        return registrationDAO.register(firstName, lastName, address, zip, state, username, password, email, ssn, securityQuestion);
    }

    public boolean bookFlight(Flight flight) {
        int currentUserId = UserSession.getInstance(0, "").getUserId();
        return bookingDAO.insertBooking(flight.getFlightId(), currentUserId);
    }

    public boolean authenticateSsn(String ssn, String email, String username) {
        return (userDAO.verifySsn(ssn, username, email));
    }

    public boolean authenticateSecurityQuestion(String email, String ssn, String username) {
        return (userDAO.verifySecurityAnswer(username, email, ssn));
    }

    public ObservableList<Booking> getBookingsByUser() {
        int currentUserId = UserSession.getInstance(0, "").getUserId();
        return BookingDAO.getBookingsByUser(currentUserId);
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
        return UserSession.getInstance(0,"").getUserId();
    }

    public ObservableList<Flight> searchFlights(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate arrivalDate) {
        return FlightDAO.searchFlight(departureCity, arrivalCity, departureDate, arrivalDate);
    }

    public ObservableList<Flight> getAllFlights() {
        return FlightDAO.getFlights();
    }

    public ObservableList<String> getCityByType(String cityType) {
        return FlightDAO.getCities(cityType);
    }
}
