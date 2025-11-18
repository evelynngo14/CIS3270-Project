package controller;

import javafx.fxml.FMXL;
import javafx.scene.control.Label;

public class AdminDashController {
    @FMXL private Label welcomeLabel;

    @FXML
    public void initialize() {
        welcomeLabel.setText("Admin Dashboard - Welcome!");
    }

    @FXML
    public void handleAddFlight() {
        // to-do: implement add flight functionality
        System.out.println("Add flight clicked");
    }

    @FXML
    public void handleManageFlights() {
        // to-do: implement flight management
        System.out.println("Manage flights clicked");
    }

    @FXML
    public void handleLogout() {
        //to-do:implement logout
        System.out.println("Logout clicked")

    }

}
