package DataAccessLayer;

import com.entities.Customer;
import com.utils.DatabaseConnection;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerImp {

    @Override
public Customer createCustomer(Customer customer) {
    try(Connection connection = DatabaseConnection.createConnection()){

        String sql = "insert into customers values(default, ?, ?)";

        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, customer.getFirstName());
        ps.setString(2, customer.getLastName());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();

        rs.next();
        customer.setCustomerId(rs.getInt("customer_id"));

        return customer;
    } catch(SQLException e){
        e.printStackTrace();
        return null;
    }
}

    @Override
    public Customer selectCustomerById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from customers where customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Customer customer = new Customer(
                    rs.getInt("customer_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );
            return customer;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }



