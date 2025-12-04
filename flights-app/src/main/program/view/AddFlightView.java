package view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import static java.lang.String.valueOf;

public class AddFlightView extends VBox {
    private Label arrivalCityLabel = new Label("Arrival City");
    private TextField arrivalCityField = new TextField("");
    private Label departureCityLabel = new Label("Departure City");
    private TextField departureCityField = new TextField("");

    private Label departureDateLabel = new Label("Departure Date");
    private DatePicker departureDatePicker = new DatePicker();

    private Label departureTimeLabel = new Label("Departure Time");
    private ChoiceBox<String> departureTimeField = new ChoiceBox<>();

    private Label arrivalDateLabel = new Label("Arrival Date");
    private DatePicker arrivalDatePicker = new DatePicker();

    private Label arrivalTimeLabel = new Label("Arrival Time");
    private ChoiceBox<String> arrivalDateField = new ChoiceBox<>();

    private Label capacityLabel = new Label("Capacity");
    private TextField capacityField = new TextField("");
    private Button addFlightButton = new Button("Add Flight to Flight List");
    private Button cancelButton = new Button("Cancel");

    public AddFlightView() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20)); // padding
        this.setPrefWidth(1200);
        this.setPrefHeight(800);


    }

    public Label getArrivalCityLabel() {
        return arrivalCityLabel;
    }

    public void setArrivalCityLabel(Label arrivalCityLabel) {
        this.arrivalCityLabel = arrivalCityLabel;
    }

    public TextField getArrivalCityField() {
        return arrivalCityField;
    }

    public void setArrivalCityField(TextField arrivalCityField) {
        this.arrivalCityField = arrivalCityField;
    }

    public Label getDepartureCityLabel() {
        return departureCityLabel;
    }

    public void setDepartureCityLabel(Label departureCityLabel) {
        this.departureCityLabel = departureCityLabel;
    }

    public TextField getDepartureCityField() {
        return departureCityField;
    }

    public void setDepartureCityField(TextField departureCityField) {
        this.departureCityField = departureCityField;
    }

    public Label getDepartureTimeLabel() {
        return departureTimeLabel;
    }

    public void setDepartureTimeLabel(Label departureTimeLabel) {
        this.departureTimeLabel = departureTimeLabel;
    }

    public DatePicker getDepartureTimeField() {
        return departureTimeField;
    }

    public void setDepartureTimeField(DatePicker departureTimeField) {
        this.departureTimeField = departureTimeField;
    }

    public Label getArrivalTimeLabel() {
        return arrivalTimeLabel;
    }

    public void setArrivalTimeLabel(Label arrivalTimeLabel) {
        this.arrivalTimeLabel = arrivalTimeLabel;
    }

    public DatePicker getArrivalTimeField() {
        return arrivalTimeField;
    }

    public void setArrivalTimeField(DatePicker arrivalTimeField) {
        this.arrivalTimeField = arrivalTimeField;
    }

    public Label getCapacityLabel() {
        return capacityLabel;
    }

    public void setCapacityLabel(Label capacityLabel) {
        this.capacityLabel = capacityLabel;
    }

    public String getCapacityField() {
        return valueOf(capacityField);
    }

    public void setCapacityField(TextField capacityField) {
        this.capacityField = capacityField;
    }

    public Button getAddFlightButton() {
        return addFlightButton;
    }

    public void setAddFlightButton(Button addFlightButton) {
        this.addFlightButton = addFlightButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
    }

    public Label getArrivalDateLabel() {
        return arrivalDateLabel;
    }

    public void setArrivalDateLabel(Label arrivalDateLabel) {
        this.arrivalDateLabel = arrivalDateLabel;
    }

    public DatePicker getArrivalDatePicker() {
        return arrivalDatePicker;
    }

    public void setArrivalDatePicker(DatePicker arrivalDatePicker) {
        this.arrivalDatePicker = arrivalDatePicker;
    }

    public Label getDepartureDateLabel() {
        return departureDateLabel;
    }

    public void setDepartureDateLabel(Label departureDateLabel) {
        this.departureDateLabel = departureDateLabel;
    }

    public DatePicker getDepartureDatePicker() {
        return departureDatePicker;
    }

    public void setDepartureDatePicker(DatePicker departureDatePicker) {
        this.departureDatePicker = departureDatePicker;
    }
}
