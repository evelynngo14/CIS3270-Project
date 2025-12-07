package model;


import dao.LoginDAO;
import dao.UserDAO;

public class Login {

    UserDAO userDAO = new UserDAO();

    public int authenticate(String username, String password) {
        int userId;

        if (username == null || username.isEmpty() ||  password == null || password.isEmpty()) {
            return -1;
        }

        // true: successful validation, false: incorrect user and password
        boolean isValid = LoginDAO.verifyCredentials(username, password);
        if (isValid) {
            return userId = userDAO.getUserId(username);
        }
        return -1;
    }
}
