package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import static java.lang.String.valueOf;

public class AddFlightView extends VBox {
    String[] times = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00"};

    private Label arrivalCityLabel = new Label("Arrival City");
    private TextField arrivalCityField = new TextField("");
    private Label departureCityLabel = new Label("Departure City");
    private TextField departureCityField = new TextField("");

    private Label departureDateLabel = new Label("Departure Date");
    private DatePicker departureDatePicker = new DatePicker();

    private Label departureTimeLabel = new Label("Departure Time");
    private ChoiceBox<String> departureTimeChoice = new ChoiceBox<>(FXCollections.observableArrayList(times));

    private Label arrivalDateLabel = new Label("Arrival Date");
    private DatePicker arrivalDatePicker = new DatePicker();

    private Label arrivalTimeLabel = new Label("Arrival Time");
    private ChoiceBox<String> arrivalTimeChoice = new ChoiceBox<>(FXCollections.observableArrayList(times));

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

    public Label getArrivalTimeLabel() {
        return arrivalTimeLabel;
    }

    public void setArrivalTimeLabel(Label arrivalTimeLabel) {
        this.arrivalTimeLabel = arrivalTimeLabel;
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

    public ChoiceBox<String> getDepartureTimeChoice() {
        return departureTimeChoice;
    }

    public void setDepartureTimeChoice(ChoiceBox<String> departureTimeChoice) {
        this.departureTimeChoice = departureTimeChoice;
    }

    public ChoiceBox<String> getArrivalTimeChoice() {
        return arrivalTimeChoice;
    }

    public void setArrivalTimeChoice(ChoiceBox<String> arrivalTimeChoice) {
        this.arrivalTimeChoice = arrivalTimeChoice;
    }
}
