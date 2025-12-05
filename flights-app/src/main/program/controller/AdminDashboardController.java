package controller;

import app.MainApp;
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

    public AdminDashboardController(MainApp navigator, Admin model) {
        this.navigator = navigator;
        this.model = model;
    }

    // FXMLLoader injects TableView obj into fx:id="flightTable"
    // called automatically by FXMLLoader after all @FXML fields are injected
    @FXML
    public void initialize() {
        // table cols
        // must match getters from Flight class
        flightIdCol.setCellValueFactory(new PropertyValueFactory<>("flightId"));
        departureCityCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureDateTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalDateTime"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        bookedSeatsCol.setCellValueFactory(new PropertyValueFactory<>("bookedSeats"));

        // load data
        ObservableList<Flight> flights = model.getAllFlights();
        flightTable.setItems(flights);

        welcomeLabel.setText("Welcome to Admin Dashboard");

    }

    // shows the flight form
    @FXML
    private void handleAddFlight(ActionEvent event) {
        System.out.println("Add flight clicked. Navigating to flight form");
        navigator.showAddFlightForm(model);
    }

    @FXML
    private void handleDeleteFlight(ActionEvent actionEvent) {
        // get current selected item
        Flight selectedFlight = flightTable.getSelectionModel().getSelectedItem();
        if (model.deleteFlight(selectedFlight)) {
            // remove in view
            flightTable.getItems().remove(selectedFlight);
        } else {
            System.err.println("Could not delete flight");
        }
    }

    private void handleManageFlights(ActionEvent event) {
        System.out.println("Manage flight clicked. Navigating to manage flight screen");
        navigator.showManageFlightsScreen(model);
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        System.out.println("Logout clicked. Returning to login screen");
        navigator.showLoginScreen();
    }
}