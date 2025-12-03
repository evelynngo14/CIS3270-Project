package model;

public class Customer extends User {

    public Customer(String username, String password, String email) {
        super(username, password, email);
    }

    public void bookFlight() {

    }

    public void cancelFlight() {
    }

    public void viewBookedFlights() {
    }

    @Override
    public String getRole() {
        return "customer";
    }
}
