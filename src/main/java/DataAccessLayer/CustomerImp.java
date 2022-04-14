package DataAccessLayer;

import entites.Customer;
import java.sql.*;
import utilities.DataBaseConnection;

public class CustomerImp implements CustomerDAO {


    public CustomerImp() {
        super();
    }

    @Override
    public Customer getCustomerId(int customerId) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from customers where customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Customer customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("customer_name"),
                    rs.getInt("login_id")
            );
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

