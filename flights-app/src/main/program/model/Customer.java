package model;

import javafx.collections.ObservableList;
import scene_management.Booking;

public class Customer extends User {

    public Customer(String username, String password, String email) {
        super(username, password, email);
    }

    public ObservableList<Flight> getAvailableFlights() {

    }

    public ObservableList<Booking> getBookings() {
    }

    @Override
    public String getRole() {
        return "customer";
    }
}
