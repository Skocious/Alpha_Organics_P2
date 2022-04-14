package src.Samantha.Dal;

import src.Samantha.Entities.Login;

public interface LoginDal {

    Login selectLoginId(String Username, String Password, int LoginId);
}
