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

    public static void showSearchFlights(Stage stage) {
        loadScene(stage, "/view_flights.fxml", "Search Flights");

    }

    public static void showBookings(Stage stage) {
        loadScene(stage, "/bookings.fxml", "Your Bookings");

    }

    private static void loadScene(Stage stage, String fxmlPath, String title) {
        try {

            Parent root = FXMLLoader.load(SceneManager.class.getResource(fxmlPath));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            System.out.println("Could not load: " + fxmlPath);
            e.printStackTrace();
        }
    }

    public static void initialize(Stage stage) {
    }
}
