package ServiceAccessLayer;

import DataAccessLayer.CustomerDAO;
import customExceptions.InvalidId;
import entities.Customer;

public class CustomerSImp implements CustomerSO {
    CustomerDAO customerDAO;

    public CustomerSImp(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer serviceGetCustomerId(int customerId) {
        try {
            return this.customerDAO.getCustomerId(customerId);
        }catch (InvalidId e) {
            throw new InvalidId("Customer Id is not correct, please try again.");
        }
    }
}
