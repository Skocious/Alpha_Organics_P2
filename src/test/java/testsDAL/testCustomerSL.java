//package testsSL;
//
//import DataAccessLayer.CustomerImp;
//import DataAccessLayer.ItemsImp;
//import ServiceAccessLayer.CustomerSImp;
//import ServiceAccessLayer.ItemsSImp;
//import entities.Customer;
//import entities.Items;
//import org.mockito.Mockito;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class testCustomerSL {
//
//    public static CustomerImp customerDAO = new CustomerImp();
//    public static CustomerSImp customerSO = new CustomerSImp(customerDAO);
//
//    @BeforeClass
//    public void setup() {
//        customerDAO = Mockito.mock(CustomerImp.class);
//        customerSO = new CustomerSImp(customerDAO);
//    }
//
//    @Test
//    public void selectCustomerIdNoId() {
//        Customer customer = new Customer(10, "Ari", 1);
//        Customer result = customerSO.serviceGetCustomerId(100);
//        Assert.assertNotSame(10, 100);
//    }
//}
//
