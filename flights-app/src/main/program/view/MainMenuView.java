package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainMenuView extends VBox {

    // 1. Fields for Controls (Exposed via Getters)
    private final TextField usernameField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Login");
    private final Button registerButton = new Button("Register");
    private final Label forgotPasswordLabel = new Label("Forgot password?");

    public MainMenuView() {
        // --- Root VBox Setup ---
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(50));

        // --- Logo ---
        Image logoImage = new Image(getClass().getResource("/images/airplane-logo.png").toExternalForm());
        ImageView logoView = new ImageView(logoImage);
        logoView.setFitWidth(150);
        logoView.setPreserveRatio(true);

        // --- Header ---
        Label welcomeLabel = new Label("Welcome to Flight Reservations");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        // --- Username Box ---
        usernameField.setPromptText("Username");
        usernameField.setMaxWidth(250);
        VBox usernameBox = new VBox(5, new Label("Username"), usernameField);
        usernameBox.setAlignment(Pos.CENTER_LEFT);
        usernameBox.setMaxWidth(250);

        // --- Forgot Password Link ---
        forgotPasswordLabel.setStyle("-fx-text-fill: #0066cc; -fx-underline: true; -fx-cursor: hand;");
        // *** The Mouse Event LOGIC (Alert) is REMOVED from here ***
        HBox forgotPasswordBox = new HBox(forgotPasswordLabel);
        forgotPasswordBox.setAlignment(Pos.CENTER_RIGHT);
        forgotPasswordBox.setMaxWidth(250);

        // --- Password Box ---
        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(250);
        VBox passwordBox = new VBox(5, new Label("Password"), passwordField, forgotPasswordBox);
        passwordBox.setAlignment(Pos.CENTER_LEFT);
        passwordBox.setMaxWidth(250);

        loginButton.setPrefWidth(250);
        registerButton.setPrefWidth(250);
        VBox buttonBox = new VBox(10, loginButton, registerButton);
        buttonBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(logoView, welcomeLabel, usernameBox, passwordBox, buttonBox);
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public Label getForgotPasswordLabel() {
        return forgotPasswordLabel;
    }
}