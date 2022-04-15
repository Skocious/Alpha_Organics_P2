package DataAccessLayer;
import entities.Login;
import utilities.DatabaseConnection;
import java.sql.*;

public class LoginImp implements LoginDAO {

    public LoginImp() {super();}


    @Override
    public Login selectProducerLoginById(int id) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from  producer where login_id = (select login_id from login where login_name = %s and pw = %s);"
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Login login = new Login(
                    rs.getInt("login_id"),
                    rs.getString("login_name"),
                    rs.getString("pw")
            );
            return login;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Login selectCustomerLoginById(int id) {
        try (Connection connection = DatabaseConnection.createConnection()) {
            String sql = "select * from  customer where login_id = (select login_id from login where login_name = %s and pw = %s);"
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Login login = new Login(
                    rs.getInt("login_id"),
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