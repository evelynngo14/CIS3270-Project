package app;

import controller.LoginController;
import controller.MainMenuController;
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
        this.primaryStage = stage;
        showLoginScreen(); // Start with the main login screen
    }

    public void showLoginScreen() {
        MainMenuView loginView = new MainMenuView();
        new MainMenuController(this, loginView);

        Scene scene = new Scene(loginView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flight Reservations Login");
        primaryStage.show();
    }

    public void showRegistrationScreen() {
        RegistrationView registrationView = new RegistrationView();
        new RegistrationController(this, registrationView);

        Scene scene = new Scene(registrationView, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Flight Reservations Registration");
        primaryStage.show();

    }

    public void showDashboard() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
