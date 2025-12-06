package controller;

import app.MainApp;
import components.FlightTableInitialize;
import dao.FlightDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Admin;
import model.Flight;

public class AdminDashboardController {

    private final MainApp navigator;
    private final Admin adminModel;
    private final Flight flightModel;

    @FXML
    private TableView<Flight> flightsTable;
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
    private TableColumn<Flight, Integer> capacityCol;
    @FXML
    private TableColumn<Flight, Integer> bookedSeatsCol;
    @FXML
    private Button addFlightButton;
    @FXML
    private Button deleteFlightButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Label welcomeLabel;
    @FXML private Button updateFlightButton;

    public AdminDashboardController(MainApp navigator, Admin adminModel, Flight flightModel) {
        this.navigator = navigator;
        this.adminModel = adminModel;
        this.flightModel = flightModel;
    }

    // FXMLLoader injects TableView obj into fx:id="flightTable"
    // called automatically by FXMLLoader after all @FXML fields are injected
    @FXML
    public void initialize() {
        FlightTableInitialize.initializeFlightTable(flightsTable, flightIdCol, departureCityCol, arrivalCityCol, departureTimeCol, arrivalTimeCol, capacityCol, bookedSeatsCol);
        ObservableList<Flight> flights = adminModel.getAllFlights();
        flightsTable.setItems(flights);
    }

    // shows the flight form
    @FXML
    private void handleAddFlight(ActionEvent event) {
        System.out.println("Add flight clicked. Navigating to flight form");
        navigator.showAddFlightForm(adminModel);
    }

    @FXML
    private void handleDeleteFlight(ActionEvent actionEvent) {
        // get current selected item
        Flight selectedFlight = flightTable.getSelectionModel().getSelectedItem();
        if (adminModel.deleteFlight(selectedFlight)) {
            // remove in view
            flightTable.getItems().remove(selectedFlight);
        } else {
            System.err.println("Could not delete flight");
        }
    }

    @FXML
    private void handleUpdateFlights(ActionEvent event) {
        Flight selectedFlight = flightTable.getSelectionModel().getSelectedItem();
        System.out.println("Manage flight clicked. Navigating to manage flight screen");
        navigator.showUpdateFlightsScreen(adminModel, selectedFlight);
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        System.out.println("Logout clicked. Returning to login screen");
        navigator.showLoginScreen();
    }
}