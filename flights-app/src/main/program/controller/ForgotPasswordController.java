package controller;

import app.MainApp;
import javafx.event.ActionEvent;
import model.Customer;
import model.User;
import view.DashboardView;
import view.ForgotPasswordView;

public class ForgotPasswordController {
    private final MainApp navigator;
    private final ForgotPasswordView view;
    private final User model;

    public ForgotPasswordController(MainApp navigator, ForgotPasswordView view, User model) {
        this.navigator = navigator;
        this.view = view;
        this.model = model;

    }

    private void handlePasswordReset(ActionEvent actionEvent) {

    }
}
