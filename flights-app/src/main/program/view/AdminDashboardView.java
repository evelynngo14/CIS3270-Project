package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Flight;

import java.time.LocalDate;
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

        TableColumn<Flight, Integer> bookedSeats = new TableColumn<>("Booked Seats");
        bookedSeats.setCellValueFactory(new PropertyValueFactory<>("bookedSeats"));

        TableColumn<Flight, String> departureCityCol = new TableColumn<>("Departure City");
        departureCityCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));

        TableColumn<Flight, String> arrivalCityCol = new TableColumn<>("Arrival City");
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));

        TableColumn<Flight, LocalDate> departureDateCol = new TableColumn<>("Departure Date");
        departureDateCol.setCellValueFactory(new PropertyValueFactory<>("departureDate"));

        TableColumn<Flight, LocalTime> departureTimeCol = new TableColumn<>("Departure Time");
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureTime"));

        TableColumn<Flight, LocalTime> arrivalTimeCol = new TableColumn<>("Arrival Time");
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));


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
