package ServiceAccessLayer;
import DataAccessLayer.LoginDAO;
import customExceptions.InvalidLogin;
import entities.Login;

public class LoginSImp implements LoginSO {
    LoginDAO loginDAO;

    public LoginSImp(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public Login serviceSelectLoginName(String Username, String Password) {
        if (Username == Username)
            return this.loginDAO.selectLoginName(Username, Password);
        else {
            throw new InvalidLogin("Username and/or Password are wrong, please try again.");
        }
    }
}






