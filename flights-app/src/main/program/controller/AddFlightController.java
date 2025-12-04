package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Admin;
import model.Flight;
import view.AddFlightView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddFlightController {
    private final MainApp navigator;
    private final AddFlightView view;
    private final Flight flightModel;
    private final Admin adminModel;

    public AddFlightController(MainApp navigator, AddFlightView view,  Flight flightModel, Admin adminModel) {
        this.navigator = navigator;
        this.view = view;
        this.adminModel = adminModel;
        this.flightModel = flightModel;

        view.getCancelButton().setOnAction(this::handleReturn);
    }

    private void handleAddFlight(ActionEvent actionEvent) {
        String departureCity = String.valueOf(view.getDepartureCityField());
        String arrivalCity = String.valueOf(view.getArrivalCityField());

        DatePicker departureDatePicker = view.getDepartureDatePicker();
        ChoiceBox<String> departureTimeField = view.getDepartureTimeChoice();

        DatePicker arrivalDatePicker = view.getArrivalDatePicker();
        ChoiceBox<String> arrivalTimeField = view.getArrivalTimeChoice();

        int capacity = Integer.parseInt(view.getCapacityField());
        int bookedSeats = flightModel.getBookedSeats();

        Flight.incrementFlightId(); // static method
        Flight newFlight = new Flight(flightModel.getFlightId(), departureCity, arrivalCity, departureTime, arrivalTime, capacity, bookedSeats);
        adminModel.addFlight(newFlight);

    }

    private void handleReturn(ActionEvent actionEvent) {
        navigator.showDashboard();
    }

}
