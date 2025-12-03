package model;

import dao.FlightDAO;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import view.AdminDashboardView;

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

    public void addFlight() {
    }

    public void updateFlight() {
    }

    public void deleteFlight() {
    }

    @Override
    public String getRole() {
        return "admin";
    }
}
