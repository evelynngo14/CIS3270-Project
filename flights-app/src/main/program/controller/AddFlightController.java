package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Admin;
import model.Flight;
import view.AddFlightView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class AddFlightController {
    private MainApp navigator;
    private final AddFlightView view;
    private final Flight flightModel;
    private Admin adminModel;

    @FXML private TextField departureCityField;
    @FXML private TextField arrivalCityField;
    @FXML private DatePicker departureDatePicker;
    @FXML private ChoiceBox<String> departureTimeChoice;
    @FXML private DatePicker arrivalDatePicker;
    @FXML private ChoiceBox<String> arrivalTimeChoice;
    @FXML private TextField capacityField;
    @FXML private Button addFlightButton;
    @FXML private Button cancelButton;

    public AddFlightController(MainApp navigator, AddFlightView view,  Flight flightModel, Admin adminModel) {
        this.navigator = navigator;
        this.view = view;
        this.adminModel = adminModel;
        this.flightModel = flightModel;
    }

    @FXML
    private LocalDateTime convertToLocalDateTime(DatePicker datePicker, ChoiceBox<String> timeChoiceBox) {
        LocalDate date = datePicker.getValue();
        if (date == null) {
            return null;
        }

        String timeString = timeChoiceBox.getValue();

        if (timeString == null || timeString.isEmpty()) {
            return null;
        }
        LocalTime time =  LocalTime.parse(timeString);
        return LocalDateTime.of(date, time);
    }

    @FXML
    private void handleAddFlight(ActionEvent actionEvent) {
        String departureCity = String.valueOf(view.getDepartureCityField());
        String arrivalCity = String.valueOf(view.getArrivalCityField());

        DatePicker departureDatePicker = view.getDepartureDatePicker();
        ChoiceBox<String> departureTimeChoice = view.getDepartureTimeChoice();

        DatePicker arrivalDatePicker = view.getArrivalDatePicker();
        ChoiceBox<String> arrivalTimeChoice = view.getArrivalTimeChoice();

        // convert DatePicker and ChoiceBox string into LocalDateTime
        LocalDateTime departureTime = convertToLocalDateTime(departureDatePicker, departureTimeChoice);
        LocalDateTime arrivalTime = convertToLocalDateTime(arrivalDatePicker, arrivalTimeChoice);

        int capacity = Integer.parseInt(view.getCapacityField());
        int bookedSeats = flightModel.getBookedSeats();

        Flight.incrementFlightId(); // static method
        Flight newFlight = new Flight(flightModel.getFlightId(), departureCity, arrivalCity, departureTime, arrivalTime, capacity, bookedSeats);
        boolean success = adminModel.addFlight(newFlight);

        if (success) {
            navigator.showAdminDashboard();
        } else {
            System.err.println("Failed to save flight to database.");
        }

    }

    @FXML
    private void handleReturn(ActionEvent actionEvent) {
        navigator.showDashboard();
    }

    public void initializeDependencies(MainApp navigator, Admin adminModel) {
        this.navigator = navigator;
        this.adminModel = adminModel;

        addFlightButton.setOnAction(this::handleAddFlight);
        cancelButton.setOnAction(this::handleReturn);
    }
}