package controller;
import app.MainApp;
import view.MainMenuView;
import model.LoginModel;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import scene_management.SceneManager; // Assuming this class handles scene switching

public class MainMenuController {

    private final MainApp navigator;
    private final MainMenuView view;
    // private final LoginModel model

    public MainMenuController(Stage stage, MainMenuView view, LoginModel model, MainApp navigator */) {
        this.navigator = navigator;
        this.view = view;
        // this.model = model;

        view.getLoginButton().setOnAction(e -> handleLogin());
        view.getRegisterButton().setOnAction(e -> handleRegister());
        view.getForgotPasswordLabel().setOnMouseClicked(e -> handleForgotPassword());
    }

    private void handleLogin() {
        String username = view.getUsernameField().getText();
        String password = view.getPasswordField().getText();

        // Pass data to the Model (Simulation)
        // boolean success = model.authenticate(username, password);

        if (username.equals("admin") && password.equals("password")) { // Simple check for demo
            navigator.showAdminDashboard()
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR, "Invalid Username or Password.");
            error.show();
        }
    }

    private void handleRegister() {
        SceneManager.showRegistrationScreen(stage);
    }

    private void handleForgotPassword() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Password Recovery");
        alert.setHeaderText(null);
        alert.setContentText("Password recovery is not implemented yet.");
        alert.showAndWait();
    }
}