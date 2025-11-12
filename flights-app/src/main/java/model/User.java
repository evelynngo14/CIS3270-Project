package model;

import java.sql.*;

public abstract class User {
    protected String firstName, lastName, mi, email, username, password, securityQuestion, ssn, address, zip, state;

    public boolean login(String inputUsername, String inputPassword) {
        String url = "jdbc:mysql://cis3270db.mysql.database.azure.com:3306/airline_reservation?useSSL=true";
        String dbUser = "cis3270db";
        String dbPass = "Administrator!";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?"; // ? is filled with user's input
            PreparedStatement stmt = conn.prepareStatement(query); // Prepared statement to prevent SQL injection
            stmt.setString(1, inputUsername); // corresponds to ? according to parameter index
            stmt.setString(2, inputPassword);

            ResultSet rs = stmt.executeQuery(); // Executes the SQL query and stores the result in a ResultSet
            if (rs.next()) {
                this.username = rs.getString("username");
                this.password = rs.getString("password");
                System.out.println("Login successful");
                return true;
            } else {
                System.out.println("Invalid credentials.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public void searchFlights(String departureCity, String destinationCity, String date) {
        String url = "mysql -h cis3270db.mysql.database.azure.com -P 3306 -u cis3270db -p";
        String dbUser = "cis3270db";
        String dbPass = "Administrator!";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPass)) {
            String query = "SELECT * FROM flights WHERE departure_city = ? AND destination_city = ? AND departure_date = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, departureCity);
            stmt.setString(2, destinationCity);
            stmt.setString(3, date); // Format: "YYYY-MM-DD"

            ResultSet rs = stmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("model.Flight ID: " + rs.getInt("flight_id"));
                System.out.println("From: " + rs.getString("departure_city"));
                System.out.println("To: " + rs.getString("destination_city"));
                System.out.println("Departure: " + rs.getString("departure_time"));
                System.out.println("Arrival: " + rs.getString("arrival_time"));
                System.out.println("Seats Available: " + (rs.getInt("capacity") - rs.getInt("booked_seats")));
            }

            if (!found) {
                System.out.println("No flights found for the given criteria.");
            }
        } catch (SQLException e) {
            System.out.println("Error searching flights: " + e.getMessage());
        }
    }

    public void forgotPassword() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String ssn) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

