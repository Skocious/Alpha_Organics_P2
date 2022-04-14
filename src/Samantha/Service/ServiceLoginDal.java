package src.Samantha.Service;

import src.Samantha.Entities.Login;

public interface LoginDal {

    Login serviceSelectLoginId(String Username, String Password, int LoginId);
}
