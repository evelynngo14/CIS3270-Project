package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import app.MainApp;
import javafx.fxml.FXML;
import model.Booking;
import model.Customer;
import view.DashboardView;
import view.MainMenuView;

public class DashboardController {

    private final MainApp navigator;
    private final DashboardView view;
    private final Customer model;

    public DashboardController(MainApp navigator, DashboardView view, Customer model) {
        this.navigator = navigator;
        this.view = view;
        this.model = model;
        //view.getWelcomeLabel().setText("Dashboard - Welcome!")

        loadBooking();

        view.getLogoutButton().setOnAction(this::handleLogout);
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
