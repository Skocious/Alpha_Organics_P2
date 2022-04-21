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
        Transaction newTransaction = new Transaction(0, 3, 1, 111, 4);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionId(), 0);
    }

    @Test
    public void createTransactionFailure() {
        Transaction newTransaction = new Transaction(0, 3, 1, 111, 4);
        Transaction resultNewTransaction = transactionDAO.createTransaction(newTransaction);
        Assert.assertNotEquals(resultNewTransaction.getTransactionId(), -1);
    }

    @Test
    public void getAllTransactionByCustomerIdSuccess() {
        Transaction transactions = transactionDAO.getAllTransactionByCustomerId(3);
        Assert.assertEquals(transactions.getCustomerId(), 3);
    }

    @Test
    public void getAllTransactionByCustomerIdFailure() {
        Transaction transactions = transactionDAO.getAllTransactionByCustomerId(3);
        Assert.assertNotEquals(transactions.getCustomerId(), -1);
    }

    @Test
    public void getAllTransactionByProducerIdSuccess() {
        Transaction transactions = transactionDAO.getAllTransactionByProducerId(1);
        Assert.assertEquals(transactions.getProducerId(), 1);
    }

    @Test
    public void getAllTransactionByProducerIdFailure() {
        Transaction transactions = transactionDAO.getAllTransactionByProducerId(1);
        Assert.assertNotEquals(transactions.getProducerId(), -1);

    }
}
