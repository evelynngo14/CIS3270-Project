import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label statusLabel;

    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = new Customer();

        boolean success = user.login(username, password);
        if (success) {
            statusLabel.setText("Login successful");
        }
        else {
            statusLabel.setText("Invalid username or password.");
        }
    }

}
