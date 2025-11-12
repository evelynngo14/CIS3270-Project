import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import scene_management.SceneManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Logo
        Image logoImage = new Image(getClass().getResource("/images/airplane-logo.png").toExternalForm());
        ImageView logoView = new ImageView(logoImage);

        logoView.setFitWidth(150);
        logoView.setPreserveRatio(true);

        // Header
        Label welcomeLabel = new Label("Welcome to Flight Reservations");
        welcomeLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");

        // Username
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        usernameField.setMaxWidth(250);

        VBox usernameBox = new VBox(5, usernameLabel, usernameField);
        usernameBox.setAlignment(Pos.CENTER_LEFT);
        usernameBox.setMaxWidth(250);

        //Forgot password
        Label forgotPassword = new Label("Forgot password?");
        forgotPassword.setStyle("-fx-text-fill: #0066cc; -fx-underline: true; -fx-cursor: hand;");
        forgotPassword.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Recovery");
            alert.setHeaderText(null);
            alert.setContentText("Password recovery is not implemented yet.");
            alert.showAndWait();
        });

        HBox forgotPasswordBox = new HBox(forgotPassword);
        forgotPasswordBox.setAlignment(Pos.CENTER_RIGHT);
        forgotPasswordBox.setMaxWidth(250);


        // Password
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(250);

        VBox passwordBox = new VBox(5, passwordLabel, passwordField, forgotPasswordBox);
        passwordBox.setAlignment(Pos.CENTER_LEFT);
        passwordBox.setMaxWidth(250);

        // Buttons
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        loginButton.setPrefWidth(250);
        registerButton.setPrefWidth(250);

        loginButton.setOnAction(e -> SceneManager.showDashboard(primaryStage));
        registerButton.setOnAction(e -> SceneManager.showRegistrationScreen(primaryStage));

        VBox buttonBox = new VBox(10, loginButton, registerButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Root layout
        VBox root = new VBox(20,
                logoView,
                welcomeLabel,
                usernameBox,
                passwordBox,
                buttonBox
        );
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
