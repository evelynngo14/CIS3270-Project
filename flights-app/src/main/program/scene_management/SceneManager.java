package scene_management;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    public static void showRegistrationScreen(Stage stage) {
        loadScene(stage, "/registration.fxml", "User Registration");
    }

    public static void showDashboard(Stage stage) {
        loadScene(stage, "/dashboard.fxml", "Dashboard");
    }

    public static void showAdminDashboard(Stage stage) {
        loadScene(stage, "/admin_dashboard.fxml", "Admin Dashboard");
    }

    private static void loadScene(Stage stage, String fxmlPath, String title) {

    }

    public static void initialize(Stage stage) {
    }
}
