package controller;
import app.MainApp;
import components.States;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Customer;
import components.States;


public class RegistrationController {
    private final MainApp navigator;
    private final MainMenuController mainMenuController;

    @FXML private Button registerButton;
    @FXML private TextField usernameField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField passwordField;
    @FXML private TextField ssnField;
    @FXML private TextField zipField;
    @FXML private ChoiceBox<String> stateChoiceBox = new ChoiceBox<>();
    @FXML private TextField emailField;
    @FXML private TextField addressField;
    @FXML private TextField securityQuestionField;
    @FXML private Button returnToLoginButton;
    @FXML private Label statusLabel;

    public RegistrationController(MainApp navigator, MainMenuController mainMenuController) {
        this.navigator = navigator;
        this.mainMenuController = mainMenuController;
    }

    public void initialize() {
        stateChoiceBox.setItems(States.getStatesList());
        securityQuestionField.setPromptText("What is your favorite animal?");
        ssnField.setPromptText("Last four digits of your SSN");
    }

    @FXML
    private boolean handleRegistration(ActionEvent event) {
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

        Customer model = new Customer();

        if (firstName == null | lastName == null | email == null | username == null | password == null | ssn == null | address == null | securityQuestion == null | zip == null | state == null) {
            statusLabel.setText("Please fill all the fields.");
            return false;
        };

        boolean success = model.registerNewUser(firstName, lastName, address, zip, state, username, password, email, ssn, securityQuestion);
        if (success) {
            navigator.showLoginScreen();
            mainMenuController.setRegistrationSuccessLabel();
            return true;
        } else {
            statusLabel.setText("There was a problem registering. Please try again.");
            return false;
        }
    }

    @FXML
    private void handleBackToLogin(ActionEvent event) {
        navigator.showLoginScreen();
    }
}
