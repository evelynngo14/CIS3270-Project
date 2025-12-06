package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Admin;
import model.Flight;

import java.time.LocalDate;
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
    @FXML private Button cancelButton;
    @FXML private Label errorLabel;

    @FXML private AdminDashboardController adminDashboardController;

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

    private void handleUpdateField(ActionEvent actionEvent) {
        String departureCity = departureCityField.getText();
        String arrivalCity = arrivalCityField.getText();
        LocalDate depDate = departureDatePicker.getValue();
        String depTime = departureTimeChoice.getValue();

        LocalDateTime updatedDepartureDateTime = depDate.atStartOfDay().plusHours(
                Integer.parseInt(depTime.substring(0, 2))
        ).plusMinutes(
                Integer.parseInt(depTime.substring(3, 5))
        );
        flightModel.setDepartureCity(departureCity);
        flightModel.setDepartureDateTime(updatedDepartureDateTime);

        boolean success = adminModel.updateFlight(flightModel);
        if (success) {
            navigator.showAdminDashboard(adminModel);
        } else {
            errorLabel.setText("Update failed. Check inputs.");
        }
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
