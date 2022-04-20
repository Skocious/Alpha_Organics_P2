package DataAccessLayer;

import entities.Customer;
import utilities.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerImp implements CustomerDAO {


    public CustomerImp() {super();}

    @Override
    public Customer getCustomerId(int customerId) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from customer where customer_id = ?";
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

