package DataAccessLayer;


import entities.Login;

public interface LoginDAO {

    Login selectLoginName(String Username, String Password);

}
