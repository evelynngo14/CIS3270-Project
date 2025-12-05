package app;
import controller.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Admin;
import model.Flight;
import model.Login;
import view.AddFlightView;
import view.RegistrationView;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class MainApp extends Application {

    public static Stage primaryStage;
    public static final int SCENE_WIDTH = 1200;
    public static final int SCENE_HEIGHT = 800;

    @Override
    public void start(Stage stage) {
        primaryStage = stage; // will NOT start without initializing
        showLoginScreen();
    }

    // fxmlPath : the path to the FXML file
    // controllerFactory : Callback represents a function that accepts one input and produces one ouput
    // Callback<Class<?>, Object> controllerFactory: given a class, return an object instance of that class
    private void loadScene(String fxmlPath, Callback<Class<?>, Object> controllerFactory, String title) {
        try {
            URL fxmlUrl = getClass().getResource(fxmlPath);
            if (fxmlUrl == null) {
                System.err.println("Couldn't find file: " + fxmlPath);
                return;
            }
            FXMLLoader loader = new FXMLLoader(fxmlUrl);

            // callback factory: allows injection
            // instantiates constructor that accepts new dependencies (e.g. new AddFlightController(navigator, model)
            loader.setControllerFactory(controllerFactory);

            Parent root = loader.load();

            primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
            primaryStage.setTitle(title);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Couldn't load scene for " + fxmlPath + ": " + e.getMessage());
        }
    }

    public void showLoginScreen() {
        Login model = new Login();

        loadScene("/view/Main_menu_view.fxml",
            type -> new MainMenuController(this, model),
            "Login"
            );
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

    public void showAdminDashboard(Admin adminModel) {
        loadScene("/view/admin_dashboard_view.fxml",
                // -- controller initialization with dependency injection --
                // type (input) is the AdminDashboardController
                // -> operator separates the input from the logic
                // output: new AdminDashboardController(this, adminModel)
                type -> new AdminDashboardController(this, adminModel),
                "Admin Dashboard"
        );
    }

    public void showForgotPasswordScreen() {
        //ForgotPasswordView forgotPasswordView = new ForgotPasswordView();
        //new ForgotPasswordController(this, forgotPasswordView);
    }

    public void showAddFlightForm(Admin adminModel) {
        loadScene("/view/AddFlightView.fxml",
        type -> new AddFlightController(this, adminModel),
                "Admin: Add new flight"
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}

// hel