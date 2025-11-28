package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import app.MainApp;

public class DashboardController {
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {

        welcomeLabel.setText("Customer Dashboard - Welcome!");
    }

    @FXML
    public void handleSearchFlights(ActionEvent event) {
        System.out.println("Search flights clicked");
        //to-do: navigate to search flight screen
        // Main.app.showSearchFlightsPage();
    }

    @FXML
    public void handleViewBooking(ActionEvent event) {
        System.out.println("View bookings clicked");
        //to-do: navigate to bookings screen
        // MainApp.showBookingsPage();
    }

    @FXML
    public void handleLogout(ActionEvent event) {
        System.out.println("Logout clicked");
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainApp.showLogin(stage);
    }

}
