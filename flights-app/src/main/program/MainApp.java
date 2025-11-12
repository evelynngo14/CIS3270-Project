import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "pass123";

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register a new account");

        loginButton.setOnAction(e -> {
            SceneManager.showLoginScreen(primaryStage);
        });
        registerButton.setOnAction(e -> {
            SceneManager.showRegistrationScreen(primaryStage);
        });

        VBox root = new VBox(10, loginButton, registerButton);
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
