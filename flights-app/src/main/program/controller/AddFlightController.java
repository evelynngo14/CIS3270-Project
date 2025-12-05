package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Admin;
import model.Customer;
import model.Flight;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AddFlightController {
    private final MainApp navigator;
    private final Admin adminModel;

    @FXML private TextField departureCityField;
    @FXML private TextField arrivalCityField;
    @FXML private DatePicker departureDatePicker;
    @FXML private ChoiceBox<String> departureTimeChoice;
    @FXML private DatePicker arrivalDatePicker;
    @FXML private ChoiceBox<String> arrivalTimeChoice;
    @FXML private TextField capacityField;
    @FXML private Button addFlightButton;
    @FXML private Button cancelButton;
    @FXML private Label errorLabel;

    public AddFlightController(MainApp navigator, Admin adminModel) {
        this.navigator = navigator;
        this.adminModel = adminModel;
    }

    @FXML
    public void initialize() {
        // 00:00, 00:30, ...
        populateTimeChoices(departureTimeChoice);
        populateTimeChoices(arrivalTimeChoice);
    }

    @FXML
    private void handleAddFlight(ActionEvent actionEvent) {
        String departureCity = departureCityField.getText();
        String arrivalCity = arrivalCityField.getText();
        // convert DatePicker and ChoiceBox string into LocalDateTime
        LocalDateTime departureTime = convertToLocalDateTime(departureDatePicker, departureTimeChoice);
        LocalDateTime arrivalTime = convertToLocalDateTime(arrivalDatePicker, arrivalTimeChoice);

        if (departureTime == null || arrivalTime == null || departureCity.isEmpty() || arrivalCity.isEmpty() || capacityField.getText().isEmpty()) {
            System.err.println("Input error. Fill in all fields.");
            return;
        }

        int capacity =  Integer.parseInt(capacityField.getText());

        // new flight
        int bookedSeats = 0;

        Flight newFlight = new Flight(
                0, // placeholder so DAO ignores it
                departureCity,
                arrivalCity,
                departureTime,
                arrivalTime,
                capacity,
                bookedSeats
        );

        boolean success = adminModel.addFlight(newFlight);
        if (success) {
            navigator.showAdminDashboard(adminModel);
        } else {
            System.err.println("Failed to save flight to database.");
        }

    }

    private void populateTimeChoices(ChoiceBox<String> choiceBox) {
        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m += 30) {
                String time = String.format("%02d:%02d", h, m);
                choiceBox.getItems().add(time);
            }
        }
    }

    private LocalDateTime convertToLocalDateTime(DatePicker datePicker, ChoiceBox<String> timeChoice) {
        LocalDate date = datePicker.getValue();
        String timeString = timeChoice.getValue();
        if (date == null || timeString == null || timeString.isEmpty()) {
            return null;
        }

        // format time string
        LocalTime time = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));

        return(LocalDateTime.of(date, time));
    }

    @FXML
    private void handleCancel(ActionEvent actionEvent) {
        navigator.showAdminDashboard(adminModel);
    }
}