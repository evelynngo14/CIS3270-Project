package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.fx.scene.control.cell.PropertyValueFactory;

public class ViewFlightsController {
    @FXML
    private TableView flightsTable;

    @FXML
    public void initialize() {
        //to-do: set up table columns
        System.out.println("Flights view initialized");
    }

    @FXML
    public void handleBookFlight() {
        //to-do: implement flight booking
        System.out.println("Book flight clicked");
    }

    @FXML
    public void handleBack() {
        //to-do: go back to dashboard
        System.out.print("Back clicked");
    }

}
