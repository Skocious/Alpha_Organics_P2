package ServiceAccessLayer;
import DataAccessLayer.LoginDAO;
import entities.Login;

import java.util.List;

public interface LoginSO extends LoginDAO {

    Login serviceSelectProducerId(String Username, String Password, int LoginId);

    Login serviceSelectCustomerId(String Username, String Password, int LoginId);

}
