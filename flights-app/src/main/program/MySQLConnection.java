import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        String dbUser = "cis";
        String dbPass = "Administrator!";
        String url = String.format("jdbc:sqlserver://flights-app.database.windows.net:1433;database=flights-db;user=cis@flights-app;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", dbPass);

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPass)) {
            System.out.println("Connection to MySQL established successfully!");
            // Perform database operations here
        } catch (SQLException e) {
            System.out.println("Error connecting to MySQL: " + e.getMessage());
        }
    }
}