package ServiceAccessLayer;

import entities.Login;

public interface LoginServiceInterface {

    Login serviceSelectProducerId(String Username, String Password, int LoginId);

    Login serviceSelectCustomerId(String Username, String Password, int LoginId);

}
