package ServiceAccessLayer;
import DataAccessLayer.CustomerDAO;
import entities.Customer;

import java.util.List;

public interface CustomerSO extends CustomerDAO {

    Customer serviceGetCustomerId(int customerId);
}
