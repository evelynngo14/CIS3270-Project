package app;

import controller.RegistrationController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import scene_management.SceneManager;
import view.MainMenuView;
import view.RegistrationView;

import static view.MainMenuView.showLogin;

public class MainApp extends Application {

    public static Stage primaryStage;
    public static final int SCENE_WIDTH = 1200;
    public static final int SCENE_HEIGHT = 800;

    @Override
    public void start(Stage stage) {
        MainApp.primaryStage = stage;
        SceneManager.initialize(stage);
        VBox root = showLogin(primaryStage);
        Scene scene = new Scene(root, 1200, 800);
        primaryStage = stage;
        primaryStage.setTitle("Flight Reservations");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
