package model;

import java.sql.*;

public abstract class User {

    protected String username;
    protected String password;
    protected String email;

    public abstract String getRole();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

