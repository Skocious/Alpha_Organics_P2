//package ServiceAccessLayer;
//
//import DataAccessLayer.CustomerDAO;
//import customExceptions.InvalidId;
//import entities.Customer;
//
//public class CustomerSImp implements CustomerSO {
//    CustomerDAO customerDAO;
//
//    public CustomerSImp(CustomerDAO customerDAO) {
//        this.customerDAO = customerDAO;
//    }
//
//    @Override
//    public Customer serviceGetCustomerId(int customerId) {
//        Customer customer = customerDAO.getCustomerId(customerId);
////        if (customer == null || customerId <= 0) {
////            throw new InvalidId("Customer Id is not correct, please try again.");
////        } else {
//            return customer;
//
////        }
//    }
//}
//
