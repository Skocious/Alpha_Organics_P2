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
    public Login selectLoginName(String Username, String Password) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from login where login_name = (select login_name from login where login_name = ? and pw = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Login login = new Login(
                    rs.getString("login_name"),
                    rs.getString("pw")
            );
            return login;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}