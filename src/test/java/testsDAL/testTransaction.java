package testsDAL;

import Api.Apps;
import DataAccessLayer.TransactionImp;
import entities.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class testTransaction {
    public static Logger logger = LogManager.getLogger(testTransaction.class);
    TransactionImp transactionDAO = new TransactionImp();

    @Test
    public void createTransactionSuccess() {
        Transaction newTransaction = new Transaction(0, "customer1", 1.99f, 10);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionId(), 0);
        logger.info("Transaction DAL Tests Starting");
    }

    @Test
    public void createTransactionFailure() {
        Transaction newTransaction = new Transaction(0, "customer2", 10000, 10);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionAmount(), 10000);
    }

    @Test
    public void getAllTransactionByUsernameSuccess() {
        List<Transaction> transaction = transactionDAO.getAllTransactionByUsername("customer1");
        Assert.assertTrue(transaction.size() >= 1);
    }
}
