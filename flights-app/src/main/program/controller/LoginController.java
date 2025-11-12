package controller;

import dao.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.User;
import model.Customer;
import scene_management.SceneManager;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label statusLabel;

    @FXML
    public void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        boolean success = UserDAO.validateLogin(username, password);

        if (success) {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            SceneManager.showDashboard();
        } else {
            statusLabel.setText("Invalid username or password.");
        }
    }

}
