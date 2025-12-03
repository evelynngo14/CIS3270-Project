package model;

import java.sql.*;

public abstract class User {

    protected String username;
    protected String password;
    protected String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public abstract String getRole();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

