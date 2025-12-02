package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ViewFlightsController {
    @FXML
    private TableView flightsTable;

    @FXML
    public void initialize() {
        //TODO: set up table columns
        System.out.println("Flights view initialized");
    }

    @FXML
    public void handleBookFlight() {
        //TODO: implement flight booking
        System.out.println("Book flight clicked");
    }

    @FXML
    public void handleBack() {
        //TODO: go back to dashboard
        System.out.print("Back clicked");
    }

}
