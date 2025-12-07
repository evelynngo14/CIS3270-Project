package model;

public class UserSession {
    private static UserSession instance;
    private int userId;
    private String username;

    private UserSession(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public static UserSession getInstance(int userId, String username) {
        if (instance == null) {
            instance = new UserSession(userId, username);
        }
        return instance;
    }

    public static void logout() {
        instance = null;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}
