package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class AddFlightView extends VBox {
    private Label arrivalCityLabel = new Label("Arrival City");
    private TextField arrivalCityField = new TextField("");
    private Label departureCityLabel = new Label("Departure City");
    private TextField departureCityField = new TextField("");
    private Label departureTimeLabel = new Label("Departure Time");
    private DatePicker departureTimeField = new DatePicker();
    private Label arrivalTimeLabel = new Label("Arrival Time");
    private DatePicker arrivalTimeField = new DatePicker();
    private Label capacityLabel = new Label("Capacity");
    private Button addFlightButton = new Button("Add Flight to Flight List");

    public AddFlightView() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20)); // padding
        this.setPrefWidth(1200);
        this.setPrefHeight(800);


    }
}
