package model;

import dao.FlightDAO;
import javafx.collections.ObservableList;

// admin logic ; fetch flight data
public class Admin extends User {

    public Admin() {
    }
    public ObservableList<Flight> getAllFlights() {
        return FlightDAO.getFlights();
    }

    public void updateFlight() {
    }

    public boolean deleteFlight(int flightId) {
        return FlightDAO.deleteFlight(flightId); // success = true
    }

    @Override
    public String getRole() {
        return "admin";
    }

    public boolean addFlight(Flight newFlight) {
        return FlightDAO.addFlight(newFlight); // success = true
    }
}
