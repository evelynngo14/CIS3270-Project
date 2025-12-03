package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import app.MainApp;
import view.MainMenuView;

public class DashboardController {
    @FXML
    private Label welcomeLabel;

    @FXML
    public void initialize() {

        welcomeLabel.setText("Customer Dashboard - Welcome!");
    }

    @FXML
    public void handleSearchFlights(ActionEvent event) {
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       //SceneManager.showSearchFlights(stage);
    }

    @FXML
    public void handleViewBooking(ActionEvent event) {
       Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       //SceneManager.showBookings(stage);
    }

    @FXML
    public void handleLogout(ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //SceneManager.showRegistrationScreen(stage);
    }

}
