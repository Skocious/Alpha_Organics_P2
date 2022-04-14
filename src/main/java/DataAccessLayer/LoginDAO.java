package DataAccessLayer;

public interface LoginDAO {

    Login selectLoginId(String Username, String pw, int LoginId);


}
