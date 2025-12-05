package controller;

import app.MainApp;
import dao.FlightDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Admin;
import model.Flight;
import view.AdminDashboardView;

import java.io.IOException;

public class AdminDashboardController {

    private final MainApp navigator;
    private final Admin model;

    @FXML
    private TableView<Flight> flightTable;
    @FXML
    private TableColumn<Flight, Integer> flightIdCol;
    @FXML
    private TableColumn<Flight, String> departureCityCol;
    @FXML
    private TableColumn<Flight, String> arrivalCityCol;
    @FXML
    private TableColumn<Flight, String> departureTimeCol;
    @FXML
    private TableColumn<Flight, String> arrivalTimeCol;
    @FXML
    private TableColumn<Flight, String> capacityCol;
    @FXML
    private TableColumn<Flight, String> bookedSeatsCol;

    public AdminDashboardController(MainApp navigator, Admin model) {
        this.navigator = navigator;
        this.model = model;
    }

    // FXMLLoader injects TableView obj into fx:id="flightTableView"
    @FXML
    public void initialize() {
        // fetch list of flights
        ObservableList<Flight> flights = model.getAllFlights();
        flightTable.setItems(flights);
    }

    // *TableView for All Flights*
    private void handleViewFlights() {
        // calls Admin Model to fetch ObservableList of flight objects, sends to View
        ObservableList<Flight> flightList = model.getAllFlights();
        flightTable.setItems(flightList);
    }

    // shows the flight form
    @FXML
    private void handleAddFlight() {
        System.out.println("Add flight clicked. Navigating to flight form");
        navigator.showAddFlightForm(model);
    }

    private void handleDeleteFlight(ActionEvent actionEvent) {
        //view.getDeleteFlightButton().setOnAction(this::handleDeleteFlight);
    }

    private void handleManageFlights() {
        System.out.println("Manage flight clicked. Navigating to manage flight screen");
    }

    private void handleLogout() {
        System.out.println("Logout clicked. Returning to login screen");
        navigator.showLoginScreen(model);
    }
}