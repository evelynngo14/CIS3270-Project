import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static void main(String[] args) {
        String url = "mysql -h cis3270db.mysql.database.azure.com -P 3306 -u cis3270db -p";
        String dbUser = "src/main/cis3270db";
        String dbPass = "Administrator!";

        try (Connection connection = DriverManager.getConnection(url, dbUser, dbPass)) {
            System.out.println("Connection to MySQL established successfully!");
            // Perform database operations here
        } catch (SQLException e) {
            System.err.println("Error connecting to MySQL: " + e.getMessage());
        }
    }
}