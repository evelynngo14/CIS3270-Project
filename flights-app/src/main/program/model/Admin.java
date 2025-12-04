package model;

import dao.FlightDAO;
import javafx.collections.ObservableList;

// admin logic ; fetch flight data
public class Admin extends User {
    protected String username = "admin";
    protected String password = "123";

    public Admin(String username, String password, String email) {
        super(username, password, email);
    }

    public ObservableList<Flight> getAllFlights() {
        return FlightDAO.getFlights();
    }

    public void updateFlight() {
    }

    public boolean deleteFlight(int flightId) {
        return FlightDAO.deleteFlight(flightId);
    }

    @Override
    public String getRole() {
        return "admin";
    }

    public boolean addFlight(Flight newFlight) {
        return false;
    }
}
