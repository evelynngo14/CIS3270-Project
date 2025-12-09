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

import java.time.LocalDate;

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
    @FXML private Button searchFlights;
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

        AddFlightController.populateTimeChoices(depTimeChoiceBox);
        AddFlightController.populateTimeChoices(arrTimeChoiceBox);

        populateCities("arrivalCity", arrivalCityList);
        populateCities("departureCity", departureCityList);

    }

    @FXML
    private void handleSearchFlights() {
        String departureCity = departureCityList.getSelectionModel().getSelectedItem();
        String arrivalCity = arrivalCityList.getSelectionModel().getSelectedItem();
        LocalDate departureDate = depDateChoiceBox.getValue();
        LocalDate arrivalDate = arrDateChoiceBox.getValue();
        ObservableList<Flight> searchedFlights = customerModel.searchFlights(departureCity, arrivalCity, departureDate, arrivalDate);
        flightsTable.setItems(searchedFlights);
        if(searchedFlights.isEmpty()) {
            statusLabel.setText("No flights found.");
        } else {
            int count = searchedFlights.size();
            statusLabel.setText("Search complete " + count + " flight(s) found.");
        }
    }

    @FXML private void handleBookFlight() {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();

        if (selectedFlight == null) {
            System.err.println("Need to select a flight");
            statusLabel.setText("Select a flight to book.");
            return;
        }
        // ensure flight is not full
        if (selectedFlight.getBookedSeats() >= selectedFlight.getCapacity()) {
            statusLabel.setText("Flight is fully booked. Please select another.");
            return; // exit if full
        }
        boolean success = customerModel.bookFlight(selectedFlight);
        if (success) {
            selectedFlight.incrementCapacity();
            navigator.showSearchFlightsScreen(customerModel);
            statusLabel.setText("Successfully booked flight.");
            flightsTable.refresh();
            statusLabel.setText("Successfully booked flight to " + selectedFlight.getArrivalCity() + ".");
        } else {
            System.err.println("Error booking flight");
            statusLabel.setText("Error booking flight.");
        }
    }

    @FXML private void handleCancel() {
        navigator.showDashboard(customerModel);
    }

    private void populateCities(String cityType, ChoiceBox<String> cityChoiceBox) {
            ObservableList<String> citiesList = customerModel.getCityByType(cityType);
            citiesList.add(0, "");
            cityChoiceBox.setItems(citiesList);
            cityChoiceBox.getSelectionModel().select(0);
    }
}
