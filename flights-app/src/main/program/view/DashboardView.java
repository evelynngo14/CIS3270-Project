package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardView {
    private Label welcomeLabel = new Label();
    private Button logoutButton = new Button("Logout");

    public Button getLogoutButton() {
        return logoutButton;
    }

}
