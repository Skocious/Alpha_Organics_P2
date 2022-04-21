package ServiceAccessLayer;

import DataAccessLayer.LoginDAO;
import entities.Login;

public interface LoginSO {

    Login serviceSelectLoginName(String Username, String Password);
}

