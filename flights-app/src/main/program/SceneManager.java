import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneManager {

    public static void showLoginScreen(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/registration.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(SceneManager.class.getResource("/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("User Registration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showRegistrationScreen(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource("/registration.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(SceneManager.class.getResource("/style.css").toExternalForm());
            stage.setScene(scene);
            stage.setTitle("User Registration");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
