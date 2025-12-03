package app;
import controller.AdminDashboardController;
import controller.MainMenuController;
import controller.RegistrationController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Admin;
import model.Login;
import view.AdminDashboardView;
import view.MainMenuView;
import view.RegistrationView;

public class MainApp extends Application {

    public static Stage primaryStage;
    public static final int SCENE_WIDTH = 1200;
    public static final int SCENE_HEIGHT = 800;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage; // will NOT start without initializing
        showLoginScreen();
    }

    public void showLoginScreen() {
        Login model = new Login();
        MainMenuView loginView = new MainMenuView();
        new MainMenuController(this, loginView, model); // 'this': MainApp

        Scene scene = new Scene(loginView, SCENE_WIDTH, SCENE_HEIGHT);
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

    public void showAdminDashboard() {
        AdminDashboardView adminDashboardView = new AdminDashboardView();
        String username = "admin";
        String password = "password";
        String email = "admin@email.com";
        Admin model = new Admin(username, password, email);
        new AdminDashboardController(this, adminDashboardView, model);

        Scene scene = new Scene(adminDashboardView, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Admin Dashboard");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
