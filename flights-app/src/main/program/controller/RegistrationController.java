package controller;
import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import components.States;
import javafx.scene.Node;

import dao.RegistrationDAO;
import view.RegistrationView;

// Main contributor: Kelly

public class RegistrationController {

    private final MainApp navigator;
    private final RegistrationView view;

    @FXML private Button registerButton;


    public RegistrationController(MainApp navigator, RegistrationView view) {
        this.navigator = navigator;
        this.view = view;

        // State Choice Box with state abbreviations
        view.getStateChoiceBox().setItems(States.getStateAbbreviations());

        view.getRegisterButton().setOnAction(this::handleRegistration);
        view.getReturnToLoginButton().setOnAction(this::handleBackToLogin);
    }

    @FXML
    private void handleRegistration(ActionEvent event) {
        if (!validateRegistrationForm()) {
            return;
        }

        String firstName = view.getFirstNameField().getText();
        String lastName = view.getLastNameField().getText();
        String email = view.getEmailField().getText();
        String username = view.getUsernameField().getText();
        String password = view.getPasswordField().getText();
        String ssn = view.getSsnField().getText();
        String address = view.getAddressField().getText();
        String zip = view.getZipField().getText();
        String state = view.getStateChoiceBox().getValue();
        String securityQuestion = view.getSecurityQuestionField().getText();

        if (state == null || state.isEmpty()) {
            view.getStatusLabel().setText("Please select a state.");
            return;
        }

        // Call the DAO to register the user
        boolean ok = RegistrationDAO.register(
                firstName,
                lastName,
                address,
                zip,
                state,
                username,
                password,
                email,
                ssn,
                securityQuestion
        );

        if (!ok) {
            view.getStatusLabel().setText("Registration failed.");
            return;
        }

        // success: show Registered and return to login
        view.getStatusLabel().setText("Registered");
        navigator.showLoginScreen();
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        navigator.showLoginScreen();
    }

    private boolean validateRegistrationForm() {
        // Reset status message
        view.getStatusLabel().setText("");

        if (view.getFirstNameField().getText().trim().isEmpty()) {
            view.getStatusLabel().setText("First name is required.");
            return false;
        }
        if (view.getLastNameField().getText().trim().isEmpty()) {
            view.getStatusLabel().setText("Last name is required.");
            return false;
        }
        if (view.getEmailField().getText().trim().isEmpty()) {
            view.getStatusLabel().setText("Email is required.");
            return false;
        }
        if (view.getUsernameField().getText().trim().isEmpty()) {
            view.getStatusLabel().setText("Username is required.");
            return false;
        }
        if (view.getPasswordField().getText().length() < 3) {
            view.getStatusLabel().setText("Password must be at least 3 characters.");
            return false;
        }
        if (view.getStateChoiceBox().getValue() == null) {
            view.getStatusLabel().setText("Please select a state.");
            return false;
        }

        if (view.getZipField().getText().trim().length() < 5) {
            view.getStatusLabel().setText("Zip code must be at least 5 digits.");
            return false;
        }

        return true;
    }
}
