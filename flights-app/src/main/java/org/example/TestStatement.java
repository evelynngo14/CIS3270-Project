package org.example;




import java.sql.*;

public class TestStatement {
	
  public static void main(String[] args)
      throws SQLException, ClassNotFoundException {
    // Load the JDBC driver
    //Class.forName("com.mysql.jdbc.Driver");
    //System.out.println("Driver loaded");

    // Establish a connection
	  
	  Connection connection = null;
	  
      connection = DriverManager.getConnection
      ("jdbc:mysql://dbtestcis3270.mysql.database.azure.com:3306/Test","azureuser","password_123");
      System.out.println("Database connected");


	  
    // Create a statement
    Statement statement = connection.createStatement();

    // Execute a statement
    ResultSet resultSet = statement.executeQuery
      ("select firstName, mi, lastName from Student where lastName " + " = 'Smith'");

    // Iterate through the result and print the student names
    while (resultSet.next())
      System.out.println(resultSet.getString(1) + "\t" +
        resultSet.getString(2) + "\t" + resultSet.getString(3));
    // Close the connection
    connection.close();
  }
}