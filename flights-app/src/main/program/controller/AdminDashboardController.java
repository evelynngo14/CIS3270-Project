package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import view.AdminDashboardView;

public class AdminDashboardController {

    private final MainApp navigator;
    private final AdminDashboardView view;

    public AdminDashboardController(MainApp navigator, AdminDashboardView view) {
        this.navigator = navigator;
        this.view = view;

        view.getWelcomeLabel().setText("Admin Dashboard - Welcome!");

        view.getAddFlightButton().setOnAction(this::handleAddFlight);
        view.getManageFlightsButton().setOnAction(this::handleManageFlights);
        view.getLogoutButton().setOnAction(this::handleLogout);
    }

    private void handleAddFlight(ActionEvent actionEvent) {
        view.getAddFlightButton().setOnAction(this::handleAddFlight);
        view.getManageFlightsButton().setOnAction(this::handleManageFlights);
        view.getLogoutButton().setOnAction(this::handleLogout);
        System.out.println("Add flight clicked. Navigating to flight form");
        // navigator.showAddFlightForm
    }

    private void handleManageFlights(ActionEvent actionEvent) {
        //TODO: implement flight TABLE VIEW
        System.out.println("Manage flight clicked. Navigating to manage flight screen");
    }

    private void handleLogout(ActionEvent actionEvent) {
        System.out.println("Logout clicked. Returning to login screen");
        navigator.showLoginScreen();
    }
}