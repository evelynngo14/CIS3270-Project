package controller;
import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import components.States;
import javafx.scene.Node;

import dao.RegistrationDAO;
import model.Customer;
import view.RegistrationView;

// Main contributor: Kelly

public class RegistrationController {

    private final MainApp navigator;
    private final RegistrationView view;

    @FXML private Button registerButton;
    @FXML private TextField usernameField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField passwordField;
    @FXML private TextField ssnField;
    @FXML private TextField zipField;
    @FXML private ChoiceBox<String> stateChoiceBox;
    @FXML private TextField emailField;
    @FXML private TextField addressField;
    @FXML private TextField securityQuestionField;
    @FXML private Button returnToLoginButton;
    @FXML private Label statusLabel;

    public RegistrationController(MainApp navigator, RegistrationView view) {
        this.navigator = navigator;
        this.view = view;

        // State Choice Box with state abbreviations

        //view.getStateChoiceBox().setItems(States.getStateAbbreviations());
    }

    @FXML
    private void handleRegistration(ActionEvent event) {

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String ssn = ssnField.getText();
        String address = addressField.getText();
        String zip = zipField.getText();
        String state = stateChoiceBox.getValue();
        String securityQuestion = securityQuestionField.getText();

        statusLabel.setText("");

        Customer model = new Customer();

        if (firstName == null | lastName == null | email == null | username == null || password == null
                | ssn == null | address == null || securityQuestion == null | zip == null | state == null) {
            statusLabel.setText("Please fill all the fields.");
        };



        // success: show Registered and return to login
        // navigator.showLoginScreen();
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        navigator.showLoginScreen();
    }
}
