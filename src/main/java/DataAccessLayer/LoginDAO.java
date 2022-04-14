package DataAccessLayer;

public interface LoginDAO {

    Login selectLoginId(String Username, String Password, int LoginId);


}
