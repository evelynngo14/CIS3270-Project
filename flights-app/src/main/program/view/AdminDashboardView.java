package view;

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
    private Label welcomeLabel;
    private Button addFlightButton = new Button("Add Flight");
    private Button manageFlightsButton = new Button("Manage Flights");
    private Button logoutButton = new Button("Logout");
    TableView<Flight> flightTable = new TableView<>();

    public AdminDashboardView() {
        this.setAlignment(Pos.CENTER);
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

        TableColumn<Flight, String> arrivalCityCol = new TableColumn<>("Arrival City");
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));

        TableColumn<Flight, LocalDateTime>  departureTimeCol = new TableColumn<>("Departure Time");
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureDateTime"));

        TableColumn<Flight, LocalDateTime> arrivalTimeCol = new TableColumn<>("Arrival Time");
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalDateTime"));

        HBox buttons =  new HBox(10, addFlightButton,manageFlightsButton,logoutButton);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(20);

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
