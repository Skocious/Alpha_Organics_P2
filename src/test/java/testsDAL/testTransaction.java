package testsDAL;

import DataAccessLayer.TransactionImp;
import entities.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testTransaction {
    TransactionImp transactionDAO = new TransactionImp();

    @Test
    public void createTransactionSuccess(){
        Transaction newTransaction = new Transaction(0, 3, 4, 1, 0);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionId(), 0);
    }

    @Test
    public void getAllTransactionByCustomerIdSuccess(){
        Transaction transactions = transactionDAO.getAllTransactionByCustomerId(1);
        Assert.assertEquals(transactions.getCustomerId(), 1);
    }

    @Test
    public void getAllTransactionByProducerId(){
        Transaction transactions = transactionDAO.getAllTransactionByProducerId(4);
        Assert.assertEquals(transactions.getProducerId(), 4);
    }

}
