import controller.LoginController;
import javafx.fxml.FXMLLoader;
import scene_management.SceneManager;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "pass123";

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label welcomeLabel = new Label("Welcome to Flight Reservations");
        //css styling:
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2a2a2a; ");

        // login fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        //Buttons
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        //ActionEvents
        loginButton.setOnAction(e -> { // LOGIN BUTTON
            SceneManager.showDashboard(primaryStage);
        });
        registerButton.setOnAction(e -> { // REGISTRATION BUTTON
            SceneManager.showRegistrationScreen(primaryStage);
        });

        VBox root = new VBox(10, welcomeLabel, usernameField, passwordField, loginButton, registerButton);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Flight Reservations");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
