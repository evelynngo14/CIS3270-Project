package controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
    @FXML private TableColumn<Booking, String> departureCityCol;
    @FXML private TableColumn<Booking, String> arrivalCityCol;
    @FXML private TableColumn<Booking, String> departureTimeCol;
    @FXML private TableColumn<Booking, String> arrivalTimeCol;
    @FXML private TableColumn<Booking, Integer> capacityCol;

    @FXML
    private void initialize() {
        FlightTableInitialize.initializeBookingTable(
                bookingsTable,
                departureCityCol,
                arrivalCityCol,
                departureTimeCol,
                arrivalTimeCol,
                capacityCol
        );

        departureCityCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFlight().getDepartureCity())
        );

        arrivalCityCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFlight().getArrivalCity())
        );

        departureTimeCol.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getFlight().getDepartureDateTime().toString())
        );

        arrivalTimeCol.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getFlight().getArrivalDateTime().toString())
        );

        capacityCol.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(cellData.getValue().getFlight().getCapacity()).asObject()
        );
        UserSession session = UserSession.getInstance();
        this.currentUserId = session.getUserId();
        this.currentUsername = session.getUsername();

        ObservableList<Booking> bookings = model.getBookingsByUser(this.currentUserId);
        bookingsTable.setItems(bookings);
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
        ObservableList<Booking> bookingList = model.getBookingsByUser(model.getUserId());

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
