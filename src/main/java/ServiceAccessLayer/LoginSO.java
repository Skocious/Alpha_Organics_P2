package ServiceAccessLayer;

import DataAccessLayer.LoginDAO;
import entities.Login;

public interface LoginSO {

    Login serviceSelectLoginId(int LoginId, String Username, String Password);
}

