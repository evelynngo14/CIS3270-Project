package controller;
import app.MainApp;
import view.MainMenuView;
import model.Login;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class MainMenuController {

    private final MainApp navigator;
    private final MainMenuView view;
    private final Login model;

    public MainMenuController(MainApp navigator, MainMenuView view, Login model) {
        this.view = view;
        this.navigator = navigator;
        this.model = model;

        view.getLoginButton().setOnAction(e -> handleLogin());
        view.getRegisterButton().setOnAction(e -> handleRegister());
        view.getForgotPasswordLabel().setOnMouseClicked(e -> handleForgotPassword());
    }

    private void handleLogin() {
        String username = view.getUsernameField().getText();
        String password = view.getPasswordField().getText();

        if (username.equals("admin") && password.equals("password")) {
            navigator.showAdminDashboard();
        }

        boolean success = model.authenticate(username, password);
        if (success) {
            System.out.println("login successful");
            navigator.showDashboard();
        } else {
            view.getLoginErrorLabel().setText("Invalid username or password");
            System.out.println("Incorrect username or password");
        }
    }

    private void handleRegister() {
        navigator.showRegistrationScreen();
    }

    private void handleForgotPassword() {
        navigator.showForgotPasswordScreen();
    }
}