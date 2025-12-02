package dao;

public interface DAO {
    String dbUser = "cis";
    String dbPass = "Administrator!";
    String url = String.format("jdbc:sqlserver://flights-app.database.windows.net:1433;database=flights-db;user=cis@flights-app;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", dbPass);

}
