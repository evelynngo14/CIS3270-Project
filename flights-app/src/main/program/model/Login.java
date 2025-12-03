package model;


import dao.LoginDAO;
import dao.UserDAO;

public class Login {

    UserDAO userDAO = new UserDAO();

    public boolean authenticate(String username, String password) {
        if (username == null || username.isEmpty() ||  password == null || password.isEmpty()) {
            return false;
        }

        // true: successful validation, false: incorrect user and password
        boolean isValid = LoginDAO.verifyCredentials(username, password);

        return isValid;
    }

    public void resetPassword(String username, String securityAnswer, String newPassword) {
        boolean success = userDAO.verifySecurityAnswer(username, securityAnswer);
        if (success) {
            userDAO.updatePassword(username, newPassword);
        }
    }
}
