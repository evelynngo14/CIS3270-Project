package controller;

import com.mysql.cj.xdevapi.Table;
import components.FlightTableInitialize;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Booking;
import model.Customer;
import model.Flight;
import model.UserSession;

public class DashboardController {

    private final MainApp navigator;
    private final Customer model;

    private int currentUserId;
    private String currentUsername;

    @FXML private Button logoutButton;
    @FXML private Button searchButton;
    @FXML private Label welcomeLabel;
    @FXML private Text bookingSuccessLabel;
    @FXML private TableView<Booking> bookingsTable;
    @FXML private TableColumn<Flight, String> departureCityCol;
    @FXML private TableColumn<Flight, String> arrivalCityCol;
    @FXML private TableColumn<Flight, String> departureTimeCol;
    @FXML private TableColumn<Flight, String> arrivalTimeCol;
    @FXML private TableColumn<Flight, Integer> capacityCol;
    @FXML private TableColumn<Flight, Integer> bookedSeatsCol;


    @FXML
    private void initialize() {
        FlightTableInitialize.initializeBookingTable(
                bookingsTable,
                departureCityCol,
                arrivalCityCol,
                departureTimeCol,
                arrivalTimeCol,
                capacityCol,
                bookedSeatsCol
        );

        departureCityCol.setCellValueFactory(new PropertyValueFactory<>("flight.departureCity"));
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("flight.arrivalCity"));
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("flight.departureDateTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("flight.arrivalDateTime"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("flight.capacity"));
        bookedSeatsCol.setCellValueFactory(new PropertyValueFactory<>("flight.bookedSeats"));

        UserSession session = UserSession.getInstance(0, "");
        this.currentUserId = session.getUserId();
        this.currentUsername = session.getUsername();

        ObservableList<Booking> flights = model.getBookingsByUser();
        bookingsTable.setItems(flights);
    }

    public DashboardController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.model = model;
    }

    @FXML private void showBookingSuccessful(ActionEvent actionEvent) {
        bookingSuccessLabel.setText("Successfully booked flight.");
    }

    @FXML
    private void showBookings() {
        ObservableList<Booking> bookingList = model.getBookingsByUser();

    }

    @FXML
    private void handleLogout(ActionEvent actionEvent) {
        System.out.println("Customer logged out");
        navigator.showLoginScreen();
    }

    @FXML
    public void showSearchFlightsScreen(ActionEvent actionEvent) {
        System.out.println("Navigating to search flights screen");
        navigator.showSearchFlightsScreen(model);
    }

}
