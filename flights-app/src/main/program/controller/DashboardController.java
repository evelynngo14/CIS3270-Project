package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import app.MainApp;
import model.Customer;
import view.AdminDashboardView;
import view.DashboardView;
import view.MainMenuView;

public class DashboardController {

    private final MainApp navigator;
    private final DashboardView view;
    private final Customer model;

    public  DashboardController(MainApp navigator, DashboardView view, Customer model) {
        this.navigator = navigator;
        this.view = view;
        this.model = model;
    }

    //view.getWelcomeLabel().setText("Dashboard - Welcome!")

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
