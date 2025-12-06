package controller;

import app.MainApp;
import components.FlightTableInitialize;
import dao.FlightDAO;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Admin;
import model.Customer;
import model.Flight;

public class SearchFlightsController {
    private final MainApp navigator;
    private final Customer customerModel;

    @FXML private ChoiceBox<String> arrivalCityList;
    @FXML private ChoiceBox<String> departureCityList;
    @FXML private Button cancelButton;
    @FXML private Button bookFlightsButton;
    @FXML private DatePicker depDateChoiceBox;
    @FXML private DatePicker arrDateChoiceBox;
    @FXML private ChoiceBox<String> depTimeChoiceBox;
    @FXML private ChoiceBox<String> arrTimeChoiceBox;
    @FXML private Button bookFlightButton;
    @FXML private Label statusLabel;

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

    public SearchFlightsController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.customerModel = model;
    }

    // table view
    @FXML
    public void initialize() {
        FlightTableInitialize.initializeFlightTable(flightsTable, flightIdCol, departureCityCol, arrivalCityCol, departureTimeCol, arrivalTimeCol, capacityCol, bookedSeatsCol);
        ObservableList<Flight> flights = customerModel.getAllFlights();
        flightsTable.setItems(flights);
    }

    @FXML
    private void handleSearchFlights() {
        customerModel.searchFlights();
    }

    @FXML
    private void handleBookFlight() {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

        if (selectedFlight == null) {
            System.err.println("Need to select a flight");
            statusLabel.setText("Select a flight to book.");
        }
        boolean success = customerModel.bookFlight(selectedFlight);
        if (success) {
            selectedFlight.incrementCapacity();
            navigator.showSearchFlightsScreen(customerModel);
            statusLabel.setText("Successfully booked flight.");
            flightsTable.refresh();
        } else {
            System.err.println("Error booking flight");
            statusLabel.setText("Error booking flight.");
        }
    }

    @FXML private void handleCancel() {
        navigator.showDashboard(customerModel);
    }

}
