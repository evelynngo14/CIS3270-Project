package app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.MainMenuView;

import static view.MainMenuView.showLogin;

public class MainApp extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) {
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
