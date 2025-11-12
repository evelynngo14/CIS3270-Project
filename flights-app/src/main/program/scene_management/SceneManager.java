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

    private static void loadScene(Stage stage, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1200, 800); // consistent sizing
            stage.setScene(scene);
            stage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
