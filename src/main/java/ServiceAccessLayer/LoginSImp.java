package ServiceAccessLayer;
import DataAccessLayer.LoginDAO;
import ServiceAccessLayer.customExceptions.InvalidLogin;
import entities.Login;

public class LoginSImp implements LoginSO {
    LoginDAO loginDAO;

    public LoginSImp(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public Login serviceSelectLoginName(String Username, String Password) {
        Login l;
        if (Username.length() <= 20 &&
            Password.length() <= 20)
            l = this.loginDAO.selectLoginName(Username, Password);
        else {
            throw new InvalidLogin("Username and/or Password is wrong, please try again.");
        }
        if (l.getUsername() != null)
            return l;
        else {
            throw new InvalidLogin("Username and/or Password is wrong, please try again.");
        }

    }

}




