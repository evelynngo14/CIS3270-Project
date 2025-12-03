package controller;

import app.MainApp;
import dao.FlightDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import model.Admin;
import model.Flight;
import view.AdminDashboardView;

public class AdminDashboardController {

    private final MainApp navigator;
    private final AdminDashboardView view;
    private final Admin model;

    public AdminDashboardController(MainApp navigator, AdminDashboardView view, Admin model) {
        this.navigator = navigator;
        this.view = view;
        this.model = model;

        view.getWelcomeLabel().setText("Admin Dashboard - Welcome!");

        handleViewFlights();

        view.getAddFlightButton().setOnAction(this::handleAddFlight);
        view.getManageFlightsButton().setOnAction(this::handleManageFlights);
        view.getLogoutButton().setOnAction(this::handleLogout);
    }

    private void handleViewFlights() {
        // calls Admin Model to fetch ObservableList of flight objects
        ObservableList<Flight> flightList = model.getAllFlights();
        view.getFlightTable().setItems(flightList);
    }

    private void handleAddFlight(ActionEvent actionEvent) {
        view.getAddFlightButton().setOnAction(this::handleAddFlight);
        view.getManageFlightsButton().setOnAction(this::handleManageFlights);
        view.getLogoutButton().setOnAction(this::handleLogout);
        System.out.println("Add flight clicked. Navigating to flight form");
        // navigator.showAddFlightForm
    }

    private void handleManageFlights(ActionEvent actionEvent) {
        System.out.println("Manage flight clicked. Navigating to manage flight screen");
    }

    private void handleLogout(ActionEvent actionEvent) {
        System.out.println("Logout clicked. Returning to login screen");
        navigator.showLoginScreen();
    }
}