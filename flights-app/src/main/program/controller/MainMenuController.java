package controller;
import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Admin;
import model.Login;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    private final MainApp navigator;
    private final Login model;


    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label loginErrorLabel;
    @FXML
    private Label forgotPasswordLabel;

    public MainMenuController(MainApp navigator, Login model) {
        this.navigator = navigator;
        this.model = model;
    }

    @FXML
    public void initialize() {
        loginErrorLabel.setText("");
    }

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        loginErrorLabel.setText("");
        Admin adminModel = new Admin();

        if (username.equals("admin") && password.equals("password")) {
            try {
                navigator.showAdminDashboard(adminModel);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        boolean success = model.authenticate(username, password);
        if (success) {
            System.out.println("login successful");
            navigator.showDashboard();
        } else {
            loginErrorLabel.setText("Invalid username or password");
            System.out.println("Incorrect username or password");
        }
    }

    @FXML
    private void handleRegister(ActionEvent event) {
        System.out.println("Navigating to registration page");
        navigator.showRegistrationScreen();
    }

    private void handleForgotPassword() {
        //navigator.showForgotPasswordScreen(); // TODO: implement
    }
}