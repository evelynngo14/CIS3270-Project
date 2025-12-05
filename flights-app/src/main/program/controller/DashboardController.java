package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Booking;
import model.Customer;

public class DashboardController {

    private final MainApp navigator;
    private final Customer model;

    @FXML private Button logoutButton;
    @FXML private Button searchButton;
    @FXML private Label welcomeLabel;

    public DashboardController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.model = model;
    }

    private void loadBooking() {
        ObservableList<Booking> bookingList = model.getBookingsByUser();
        //view.getBookingList.setItems(bookingList);
    }

    @FXML
    private void handleLogout(ActionEvent actionEvent) {
        System.out.println("Customer logged out");
        navigator.showLoginScreen();
    }
}
