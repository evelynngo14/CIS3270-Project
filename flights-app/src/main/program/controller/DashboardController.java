package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {
    @FXML private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Customer Dashboard - Welcome!");
    }

    @FXML
    public void handleSearchFlights() {
        //to-do: implement flight search
        System.out.println("Search flights clicked");
    }

    @FXML
    public void handleViewBooking() {
        //to-do: view bookings
        System.out.println("View bookings clicked");
    }

    @FXML
    public void handleLogout() {
        //to-do: implement logout
        System.out.println("Logout clicked");
    }

}
