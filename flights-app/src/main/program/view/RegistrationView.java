package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

public class RegistrationView extends VBox {

    private final TextField firstNameField = new TextField();
    private final TextField miField = new TextField();
    private final TextField lastNameField = new TextField();
    private final TextField emailField = new TextField();
    private final TextField usernameField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final TextField ssnField = new TextField();
    private final TextField addressField = new TextField();
    private final TextField zipField = new TextField();
    private final ChoiceBox<String> stateChoiceBox = new ChoiceBox<>(); // Assuming String type
    private final TextField securityQuestionField = new TextField();
    private final Button registerButton = new Button("Register");
    private final Button returnToLoginButton = new Button("Return to Login");
    private final Label statusLabel = new Label();

    public RegistrationView() {
        // Set root VBox properties
        this.setAlignment(Pos.CENTER);
        this.setPrefHeight(800);
        this.setPrefWidth(1200);
        this.setSpacing(20);

        // Header Label
        Label headerLabel = new Label("Create Account");
        headerLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #2a2a2a;");
        headerLabel.setAlignment(Pos.CENTER);

        // GridPane Setup
        GridPane gridPane = createGridPane();

        // Left Column
        gridPane.add(new Label("First Name:"), 0, 0);
        gridPane.add(firstNameField, 1, 0);

        gridPane.add(new Label("Middle Initial:"), 0, 1);
        gridPane.add(miField, 1, 1);

        gridPane.add(new Label("Last Name:"), 0, 2);
        gridPane.add(lastNameField, 1, 2);

        gridPane.add(new Label("Email:"), 0, 3);
        gridPane.add(emailField, 1, 3);

        gridPane.add(new Label("Username:"), 0, 4);
        gridPane.add(usernameField, 1, 4);

        gridPane.add(new Label("Password:"), 0, 5);
        gridPane.add(passwordField, 1, 5);

        // Right Column
        gridPane.add(new Label("SSN:"), 2, 0);
        gridPane.add(ssnField, 3, 0);

        gridPane.add(new Label("Address:"), 2, 1);
        gridPane.add(addressField, 3, 1);

        gridPane.add(new Label("ZIP Code:"), 2, 2);
        gridPane.add(zipField, 3, 2);

        gridPane.add(new Label("State:"), 2, 3);
        gridPane.add(stateChoiceBox, 3, 3);

        gridPane.add(new Label("Security Question:"), 2, 4);
        securityQuestionField.setText("What city were you born in?");
        securityQuestionField.setOpacity(0.67);
        gridPane.add(securityQuestionField, 3, 4);

        registerButton.setPrefWidth(120);
        GridPane.setColumnIndex(registerButton, 2);
        GridPane.setRowIndex(registerButton, 11);
        gridPane.getChildren().add(registerButton);

        returnToLoginButton.setPrefWidth(120);
        GridPane.setColumnIndex(returnToLoginButton, 2);
        GridPane.setRowIndex(returnToLoginButton, 13);
        gridPane.getChildren().add(returnToLoginButton);

        // Add components to the root VBox
        this.getChildren().addAll(headerLabel, gridPane);
    }


    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(40);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20, 20, 20, 20));

        ColumnConstraints col1 = new ColumnConstraints(75); // Label column left
        col1.setHalignment(javafx.geometry.HPos.LEFT);
        ColumnConstraints col2 = new ColumnConstraints(200); // Field column left
        col2.setHalignment(javafx.geometry.HPos.LEFT);
        ColumnConstraints col3 = new ColumnConstraints(100); // Label column right
        col3.setHalignment(javafx.geometry.HPos.LEFT);
        ColumnConstraints col4 = new ColumnConstraints(250); // Field column right
        col4.setHalignment(javafx.geometry.HPos.LEFT);

        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);

        for (int i = 0; i < 8; i++) {
            gridPane.getRowConstraints().add(new RowConstraints());
        }

        return gridPane;
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public TextField getMiField() {
        return miField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public TextField getEmailField() {
        return emailField;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public TextField getSsnField() {
        return ssnField;
    }

    public TextField getAddressField() {
        return addressField;
    }

    public TextField getZipField() {
        return zipField;
    }

    public ChoiceBox<String> getStateChoiceBox() {
        return stateChoiceBox;
    }

    public TextField getSecurityQuestionField() {
        return securityQuestionField;
    }

    public Button getRegisterButton() {
        return registerButton;
    }

    public Button getReturnToLoginButton() {
        return returnToLoginButton;
    }

    public Labeled getStatusLabel() {
        return statusLabel;
    }
}