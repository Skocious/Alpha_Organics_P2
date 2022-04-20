package testsDAL;
import DataAccessLayer.CustomerImp;
import entities.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.List;


public class testCustomer {
    CustomerImp customerDAO = new CustomerImp();

    @Test
    public void selectCustomerByIdSuccess() {
        Customer customer = customerDAO.getCustomerId(3);
        Assert.assertEquals(customer.getCustomer_id(), 3);
    }

    @Test
    public void selectCustomerByIdFailure() {
        Customer customer = customerDAO.getCustomerId(-1);
        Assert.assertNull(customer);
    }

    @Test
    public void selectCustomerByIdFailure2() {
        Customer customer = customerDAO.getCustomerId(2);
        Assert.assertNotEquals(customer.getCustomer_id(), 1);

    }
}