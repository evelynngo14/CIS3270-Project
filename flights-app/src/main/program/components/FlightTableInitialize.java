package components;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Booking;
import model.Flight;

public class FlightTableInitialize {
    public static void initializeFlightTable(TableView<Flight> flightTable,
                                             TableColumn<Flight, Integer> flightIdCol,
                                             TableColumn<Flight, String> departureCityCol,
                                             TableColumn<Flight, String> arrivalCityCol,
                                             TableColumn<Flight, String> departureTimeCol,
                                             TableColumn<Flight, String> arrivalTimeCol,
                                             TableColumn<Flight, Integer> capacityCol,
                                             TableColumn<Flight, Integer> bookedSeatsCol) {

        // table cols
        // must match getters from Flight class

        departureCityCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureDateTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalDateTime"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        bookedSeatsCol.setCellValueFactory(new PropertyValueFactory<>("bookedSeats"));
    }

    public static void initializeBookingTable(TableView<Booking> bookingsTable,
                                             TableColumn<Flight, String> departureCityCol,
                                             TableColumn<Flight, String> arrivalCityCol,
                                             TableColumn<Flight, String> departureTimeCol,
                                             TableColumn<Flight, String> arrivalTimeCol,
                                             TableColumn<Flight, Integer> capacityCol,
                                             TableColumn<Flight, Integer> bookedSeatsCol) {

        // table cols
        // must match getters from Flight class

        departureCityCol.setCellValueFactory(new PropertyValueFactory<>("departureCity"));
        arrivalCityCol.setCellValueFactory(new PropertyValueFactory<>("arrivalCity"));
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureDateTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalDateTime"));
        capacityCol.setCellValueFactory(new PropertyValueFactory<>("capacity"));
        bookedSeatsCol.setCellValueFactory(new PropertyValueFactory<>("bookedSeats"));
    }

}
