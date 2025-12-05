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
    @FXML private Label newPasswordLabel;
    @FXML private TextField newPasswordField;

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
        String securityQuestion = securityQuestionField.getText();
        String email = emailField.getText();
        String ssn = ssnField.getText();
        String newPassword = newPasswordField.getText();

        securityQuestionErrorLabel.setText("");
        boolean verifySecurityQuestion = model.authenticateSecurityQuestion(username, ssn, securityQuestion);
        boolean verifySsn = model.authenticateSsn(ssn, email, username);

        // will show ssnErrorLabel OR securityQuestionErrorLabel, not both
        if (!verifySsn) {
            ssnErrorLabel.setText("Error verifying SSN, email, or username.");
        } else {
            if (!verifySecurityQuestion) {
                System.out.println("Answer to security question is incorrect.");
                securityQuestionErrorLabel.setText("Answer to security question is incorrect.");
            }
        }

        if (verifySecurityQuestion && verifySsn) {
            System.out.println("Password reset successful.");
            model.resetPassword(username, newPassword);
            navigator.showLoginScreen();
            return true;
        } else {
            securityQuestionErrorLabel.setText("Failed verification. Try again.");
            return false;
        }
    }
}
