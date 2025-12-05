package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import model.Customer;
import model.User;
import view.DashboardView;

public class ForgotPasswordController {
    private final MainApp navigator;
    private final User model;

    public ForgotPasswordController(MainApp navigator, User model) {
        this.navigator = navigator;
        this.model = model;

    }

    private void handlePasswordReset(ActionEvent actionEvent) {

    }
}
