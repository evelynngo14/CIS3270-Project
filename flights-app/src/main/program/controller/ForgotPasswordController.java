package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.User;
import view.DashboardView;

public class ForgotPasswordController {
    private final MainApp navigator;
    private final Customer model;

    @FXML private TextField usernameField;
    @FXML private TextField securityQuestionField;
    @FXML private Text securityQuestion;
    @FXML private TextField securityAnswerField;

    public ForgotPasswordController(MainApp navigator, Customer model) {
        this.navigator = navigator;
        this.model = model;

    }

    @FXML
    private void handlePasswordReset(ActionEvent actionEvent) {

    }
}
