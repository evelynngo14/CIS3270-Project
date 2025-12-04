package controller;

import app.MainApp;
import dao.FlightDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;
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
        view.getDeleteFlightButton().setOnAction(this::handleDeleteFlight);
        view.getLogoutButton().setOnAction(this::handleLogout);
    }

    // *TableView for All Flights*
    private void handleViewFlights() {
        // calls Admin Model to fetch ObservableList of flight objects, sends to View
        ObservableList<Flight> flightList = model.getAllFlights();
        view.getFlightTable().setItems(flightList);
    }

    // shows the flight form
    private void handleAddFlight(ActionEvent actionEvent) {
        Admin adminModel = new Admin();
        System.out.println("Add flight clicked. Navigating to flight form");
        navigator.showAddFlightForm(adminModel);
    }

    private void handleDeleteFlight(ActionEvent actionEvent) {
        view.getDeleteFlightButton().setOnAction(this::handleDeleteFlight);
    }

    private void handleManageFlights(ActionEvent actionEvent) {
        view.getManageFlightsButton().setOnAction(this::handleManageFlights);
        System.out.println("Manage flight clicked. Navigating to manage flight screen");
    }

    private void handleLogout(ActionEvent actionEvent) {
        System.out.println("Logout clicked. Returning to login screen");
        navigator.showLoginScreen();
    }
}