package testsDAL;

import DataAccessLayer.TransactionImp;
import entities.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class testTransaction {
    TransactionImp transactionDAO = new TransactionImp();

    @Test
    public void createTransactionSuccess() {
        Transaction newTransaction = new Transaction(0, "customer1", 1.99f, 2);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionId(), 0);
    }

    @Test
    public void createTransactionFailure() {
        Transaction newTransaction = new Transaction(0, "customer2", 10000, 2);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionAmount(), 10000);
    }

    @Test
    public void getAllTransactionByUsernameSuccess() {
        List<Transaction> transaction = transactionDAO.getAllTransactionByUsername("customer1");
        Assert.assertTrue(transaction.size() >= 1);
    }

//    @Test
//    public void getAllTransactionByUsernameFailure() {
//        Transaction transactions = transactionDAO.getAllTransactionByUsername("customer2");
//        Assert.assertNotEquals(transactions.getUsername(), "customer1");
//    }
}
