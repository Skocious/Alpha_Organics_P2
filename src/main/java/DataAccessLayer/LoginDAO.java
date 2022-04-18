package DataAccessLayer;


import entities.Login;

public interface LoginDAO {

    Login selectLoginId(int LoginId, String Username, String Password);

}
