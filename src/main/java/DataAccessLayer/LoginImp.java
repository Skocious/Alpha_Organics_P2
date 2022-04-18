package DataAccessLayer;
import entities.Login;
import utilities.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginImp implements LoginDAO {

    public LoginImp() {
        super();
    }

    @Override
    public Login selectLoginId(int LoginId, String Username, String Password) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from login where login_id = (select login_id from login where login_name = %s and pw = %s)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, LoginId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Login login = new Login(
                    rs.getInt("login_id"),
                    rs.getString("login_name"),
                    rs.getInt("pw")
            );
            return login;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}