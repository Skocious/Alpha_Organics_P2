package DataAccessLayer;


import entities.Login;

public interface LoginDAO {


public interface LoginDAO {

    Login selectProducerId(String Username, String Password, int LoginId);

    Login selectCustomerId(String Username, String Password, int LoginId);
}
