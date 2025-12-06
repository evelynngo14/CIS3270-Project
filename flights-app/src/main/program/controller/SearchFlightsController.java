package controller;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Admin;
import model.Customer;
import model.Flight;

public class SearchFlightsController {
    private final MainApp navigator;
    private final Customer customerModel;

    @FXML
    private ChoiceBox<String> arrivalCityList;
    @FXML private ChoiceBox<String> departureCityList;
    @FXML private Button logoutButton;
    @FXML private Button bookFlightsButton;
    @FXML private DatePicker depDateChoiceBox;
    @FXML private DatePicker arrDateChoiceBox;
    @FXML private ChoiceBox<String> depTimeChoiceBox;
    @FXML private ChoiceBox<String> arrTimeChoiceBox;

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

    public SearchFlightsController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.customerModel = model;
    }

    // table view
    @FXML
    public static void initialize() {
        Admin adminModel = new Admin();
        AdminDashboardController.initialize(adminModel);
    }

    @FXML
    private void handleSearchFlights() {
        customerModel.searchFlights();
    }

    @FXML private void handleBookFlight() {
        //customerModel.bookFlight();
    }

}
