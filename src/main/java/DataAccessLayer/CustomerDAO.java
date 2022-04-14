package DataAccessLayer;

public interface CustomerDAO {

 Consumer selectConsumerId(int ConsumerId, String ConsumerUsername, String ConsumerPassword, int LoginId);


    Customer selectCustomerById(int id);



}
