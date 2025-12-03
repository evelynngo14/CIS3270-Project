package model;

import dao.FlightDAO;
import javafx.collections.ObservableList;

// admin logic ; fetch flight data
public class Admin extends User {
    // TODO: implement a way to login as admin
    protected String username = "admin";
    protected String password = "123";

    public ObservableList<Flight> getAllFlights() {
        return FlightDAO.getFlights();
    }

    public void addFlight() {
    }

    public void updateFlight() {
    }

    public void deleteFlight() {
    }
}
