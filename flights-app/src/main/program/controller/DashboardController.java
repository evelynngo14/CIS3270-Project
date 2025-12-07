package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import model.Booking;
import model.Customer;
import model.Flight;
import model.UserSession;

public class DashboardController {

    private final MainApp navigator;
    private final Customer model;

    private int currentUserId;
    private String currentUsername;

    @FXML private Button logoutButton;
    @FXML private Button searchButton;
    @FXML private Label welcomeLabel;
    @FXML private Text bookingSuccessLabel;

    @FXML
    private void initialize() {
        UserSession session = UserSession.getInstance(0, "");

        this.currentUserId = session.getUserId();
        this.currentUsername = session.getUsername();

        showBookings();
    }

    public DashboardController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.model = model;
    }

    @FXML private void showBookingSuccessful(ActionEvent actionEvent) {
        bookingSuccessLabel.setText("Successfully booked flight.");
    }

    @FXML
    private void showBookings() {
        ObservableList<Booking> bookingList = model.getBookingsByUser(this.currentUserId);
        //view.getBookingList.setItems(bookingList);
    }

    @FXML
    private void handleLogout(ActionEvent actionEvent) {
        System.out.println("Customer logged out");
        navigator.showLoginScreen();
    }

    @FXML
    public void showSearchFlightsScreen(ActionEvent actionEvent) {
        System.out.println("Navigating to search flights screen");
        navigator.showSearchFlightsScreen(model);
    }

}
