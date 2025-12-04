package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

import static java.lang.String.valueOf;

public class AddFlightView extends VBox {
    String[] times = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    private Label headerLabel = new Label("Add Flight Form");

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
        //vbox properties
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20)); // padding
        this.setPrefWidth(1200);
        this.setPrefHeight(800);

        this.setSpacing(10);

        //component properties

        HBox departureCityHBox = new HBox();
        departureCityHBox.getChildren().add(departureCityLabel);
        departureCityHBox.getChildren().add(departureCityField);
        departureCityHBox.setAlignment(Pos.CENTER);
        departureCityHBox.setSpacing(10);

        HBox arrivalCityHBox = new HBox();
        arrivalCityHBox.getChildren().add(arrivalCityLabel);
        arrivalCityHBox.getChildren().add(arrivalCityField);
        arrivalCityHBox.setAlignment(Pos.CENTER);
        arrivalCityHBox.setSpacing(10);

        departureCityField.setMaxWidth(100);
        arrivalCityField.setMaxWidth(100);
        capacityField.setMaxWidth(50);


        //add components to vbox
        this.getChildren().addAll(
        headerLabel,
        departureCityHBox,
        arrivalCityHBox,
        departureDateLabel, departureDatePicker,
        departureTimeLabel, departureTimeChoice,
        arrivalDateLabel, arrivalDatePicker,
        arrivalTimeLabel, arrivalTimeChoice,
        capacityLabel, capacityField,
        addFlightButton, cancelButton
        );

    }

    public Label getArrivalCityLabel() {
        return arrivalCityLabel;
    }

    public TextField getArrivalCityField() {
        return arrivalCityField;
    }

    public Label getDepartureCityLabel() {
        return departureCityLabel;
    }

    public TextField getDepartureCityField() {
        return departureCityField;
    }


    public Label getDepartureTimeLabel() {
        return departureTimeLabel;
    }


    public Label getArrivalTimeLabel() {
        return arrivalTimeLabel;
    }

    public Label getCapacityLabel() {
        return capacityLabel;
    }

    public String getCapacityField() {
        return capacityField.getText();
    }

    public Button getAddFlightButton() {
        return addFlightButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Label getArrivalDateLabel() {
        return arrivalDateLabel;
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


    public DatePicker getDepartureDatePicker() {
        return departureDatePicker;
    }

    public ChoiceBox<String> getDepartureTimeChoice() {
        return departureTimeChoice;
    }
    public ChoiceBox<String> getArrivalTimeChoice() {
        return arrivalTimeChoice;
    }
}
