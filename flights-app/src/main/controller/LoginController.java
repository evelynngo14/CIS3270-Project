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
            //This line retrieves the current window (Stage) that contains the usernameField:
            //TODO: change stage
            Stage stage = (Stage) usernameField.getScene().getWindow();
            if (username.equals("admin")) {
                SceneManager.showAdminDashboard(stage);
            } else {
                SceneManager.showDashboard(stage);
            }
        } else {
            statusLabel.setText("Invalid username or password.");
        }
    }
}

