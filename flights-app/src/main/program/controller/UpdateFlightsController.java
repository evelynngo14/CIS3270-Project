package controller;

import app.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Admin;
import model.Flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateFlightsController {
    private final MainApp navigator;
    private final Admin adminModel;
    private final Flight flightModel;


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

    public UpdateFlightsController(MainApp navigator, Admin adminModel, Flight flightModel) {
        this.navigator = navigator;
        this.adminModel = adminModel;
        this.flightModel = flightModel;

    }

    @FXML public void initialize() {

        AddFlightController.populateTimeChoices(departureTimeChoice);
        AddFlightController.populateTimeChoices(arrivalTimeChoice);

        departureCityField.setText(flightModel.getDepartureCity());
        arrivalCityField.setText(flightModel.getArrivalCity());

        setDateTimeField(flightModel.getDepartureDateTime(),
                departureDatePicker,
                departureTimeChoice
        );
        setDateTimeField(flightModel.getArrivalDateTime(),
                arrivalDatePicker,
                arrivalTimeChoice);

        capacityField.setText(String.valueOf(flightModel.getCapacity()));
    }

    private void handleUpdateField() {
        String departureCity = departureCityField.getText();
    }

    private void setDateTimeField(LocalDateTime dateTime, DatePicker datePicker, ChoiceBox<String> timeChoice) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        try {
            datePicker.setValue(dateTime.toLocalDate());
            // format into military time
            String timeOnly = dateTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
            timeChoice.getSelectionModel().select(timeOnly);
        } catch (Exception e) {
            System.err.println("Error parsing date/time string for update: " + e.getMessage());
        }
    }



}
