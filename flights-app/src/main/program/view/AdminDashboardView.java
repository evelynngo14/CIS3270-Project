package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AdminDashboardView {
    private Label welcomeLabel;
    private Button addFlightButton;
    private Button manageFlightsButton;
    private Button logoutButton;

    public AdminDashboardView() {

    }

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public Button getAddFlightButton() {
        return addFlightButton;
    }

    public Button getManageFlightsButton() {
        return manageFlightsButton;
    }

    public Button getLogoutButton() {
        return logoutButton;
    }
}
