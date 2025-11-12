package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import components.States;
import javafx.scene.Node;

import java.sql.SQLException;

public class RegistrationController {
    @FXML private TextField firstNameField;
    @FXML private TextField miField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField ssnField;
    @FXML private TextField addressField;
    @FXML private TextField zipField;
    @FXML private ChoiceBox<String> stateChoiceBox;
    @FXML private TextField securityQuestionField;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        // JavaFX method called when FXML is loaded, used to populate ChoiceBox
        stateChoiceBox.setItems(States.getStateAbbreviations());
    }

    @FXML
    public void handleRegistration(ActionEvent event) throws SQLException {
        //TODO: form validation
        String firstName = firstNameField.getText();
        String mi = miField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String ssn = ssnField.getText();
        String address = addressField.getText();

        String zip = zipField.getText();

        String state = stateChoiceBox.getValue();
        if (state == null || state.isEmpty()) {
            statusLabel.setText("Please select a state.");
            return;
        }

        String securityQuestion = securityQuestionField.getText();

    }
    @FXML
    private void handleBackToLogin(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        MainApp.showLogin(stage);
    }
}
