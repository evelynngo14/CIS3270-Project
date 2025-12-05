package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.User;

public class ForgotPasswordController {
    private final MainApp navigator;
    private final Customer model;

    @FXML private TextField usernameField;
    @FXML private TextField securityQuestionField;
    @FXML private Text securityQuestion;
    @FXML private TextField securityAnswerField;
    @FXML private Button returnButton;
    @FXML private Label emailLabel;
    @FXML private TextField  emailField;
    @FXML private Label ssnLabel;
    @FXML private TextField ssnField;
    @FXML private Label errorLabel;
    @FXML private Label securityQuestionErrorLabel;
    @FXML private Label ssnErrorLabel;

    public ForgotPasswordController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.model = model;
    }

    @FXML
    private void handleReturn(ActionEvent event) {
        System.out.println("Returning to login screen.");
        navigator.showLoginScreen();
    }

    @FXML
    private boolean handlePasswordReset(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String securityAnswer = securityQuestionField.getText();
        String email = emailField.getText();
        String ssn = ssnField.getText();

        securityQuestionErrorLabel.setText("");
        Customer model = new Customer();

        boolean verifySecurityAnswer = model.authenticateSecurityQuestion(username, ssn, securityAnswer);
        boolean verifySsn = model.authenticateSsn(ssn, email, username);

        if (!verifySecurityAnswer) {
            System.out.println("Answer to security question is incorrect.");
            securityQuestionErrorLabel.setText("Answer to security question is incorrect.");
        }

        if (!verifySsn) {
            ssnErrorLabel.setText("Error verifying SSN, email, or username.");
        }

        if (verifySecurityAnswer && verifySsn) {
            System.out.println("Password reset successful.");
            return true;
        } else {
            errorLabel.setText("Failed verification. Try again.");
            return false;
        }
    }
}
