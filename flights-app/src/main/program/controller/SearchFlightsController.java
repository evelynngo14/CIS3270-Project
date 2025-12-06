package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class SearchFlightsController {

    @FXML
    private ChoiceBox<String> arrivalCityList;
    @FXML private ChoiceBox<String> departureCityList;
    @FXML private Button logoutButton;
    @FXML private Button bookFlightsButton;
    @FXML private DatePicker depDateChoiceBox;
    @FXML private DatePicker arrDateChoiceBox;
    @FXML private ChoiceBox<String> depTimeChoiceBox;
    @FXML private ChoiceBox<String> arrTimeChoiceBox;

}
