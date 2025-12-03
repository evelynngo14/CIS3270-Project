package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AdminDashboardView extends VBox {
    private Label welcomeLabel = new Label();
    private Button addFlightButton = new Button("Add Flight");
    private Button manageFlightsButton = new Button("Manage Flights");
    private Button logoutButton = new Button("Logout");
    TableView<Flight> flightTable = new TableView<>();

    public AdminDashboardView() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setPrefHeight(800);
        this.setPrefWidth(1200);
        this.setSpacing(20);

        // TableView Columns
        TableColumn<Flight, Integer> flightIdCol = new TableColumn<>("Flight ID");
        flightIdCol.setCellValueFactory(new PropertyValueFactory<>("flightId"));

        TableColumn<Flight, Integer> capacityCol = new TableColumn<>("Capacity");
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));

        TableColumn<Flight, Integer> bookedSeatsCol = new TableColumn<>("Booked Seats");
        bookedSeatsCol.setCellValueFactory(new PropertyValueFactory<>("bookedSeats"));

        TableColumn<Flight, String> departureCityCol = new TableColumn<>("Departure City");
        departureCityCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
        departureCityCol.setPrefWidth(150);

        TableColumn<Flight, String> arrivalCityCol = new TableColumn<>("Arrival City");
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
        arrivalCityCol.setPrefWidth(150);

        TableColumn<Flight, LocalDateTime>  departureTimeCol = new TableColumn<>("Departure Time");
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureDateTime"));
        departureTimeCol.setPrefWidth(150);

        TableColumn<Flight, LocalDateTime> arrivalTimeCol = new TableColumn<>("Arrival Time");
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalDateTime"));
        arrivalTimeCol.setPrefWidth(150);

        HBox buttons =  new HBox(10, addFlightButton,manageFlightsButton,logoutButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

        // ignore this error. runs fine
        flightTable.getColumns().addAll(
                flightIdCol, departureCityCol, arrivalCityCol,
                departureTimeCol, arrivalTimeCol, capacityCol,
                bookedSeatsCol
        );

        this.getChildren().addAll(
                welcomeLabel,
                new Separator(),
                flightTable,
                buttons
        );

    }

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public TableView<Flight> getFlightTable() {
        return flightTable;
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
