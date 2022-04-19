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
    public Login serviceSelectLoginId(int LoginId, String Username, String Password) {
        try {
            return this.loginDAO.selectLoginId(LoginId, Username, Password);
        } catch (InvalidLogin e) {
            throw new InvalidLogin("Username and/or Password are wrong, please try again.");
        }
    }
}






