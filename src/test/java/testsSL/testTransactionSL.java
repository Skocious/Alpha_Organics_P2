package testsSL;

import DataAccessLayer.TransactionImp;
import ServiceAccessLayer.TransactionSImp;
import customExceptions.InvalidId;
import entities.Transaction;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class testTransactionSL {
    public static TransactionImp transactionDAO = new TransactionImp();
    public static TransactionSImp transactionSO = new TransactionSImp(transactionDAO);
    public static Transaction testMock = new Transaction(1, "customer1", 100f, 1);
    public static List<Transaction> listMock = new ArrayList<Transaction>();

    @BeforeClass
    public void setup() {
        transactionDAO = Mockito.mock(TransactionImp.class);
        transactionSO = new TransactionSImp(transactionDAO);
    }

    @Test
    public void serviceCreateTransactionSuccess(){
        Mockito.doReturn(new Transaction(1, "customer1", 100f, 1)).when(transactionDAO).createTransaction(testMock);
        Transaction result = transactionSO.serviceCreateTransaction(testMock);
        Assert.assertEquals(result.getTransactionId(), 1);
    }

    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceCreateTransactionFailureUsernameTooLong(){
        Transaction transaction = new Transaction(1, "toooooolooooonnngggggg", 100f, 1);
        Transaction result = transactionSO.serviceCreateTransaction(transaction);
        Assert.assertNotSame(result.getUsername(), "customer1");
    }

    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceCreateTransactionFailureItemPriceTooHigh(){
        Transaction transaction = new Transaction(1, "customer1", 100000f, 1);
        Transaction result = transactionSO.serviceCreateTransaction(transaction);
        Assert.assertNotEquals(result.getTransactionAmount(), 100000f);
    }
    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceCreateTransactionPriceNotZeroNoFreebies(){
        Transaction transaction = new Transaction(1, "customer1", 0, 1);
        Transaction result = transactionSO.serviceCreateTransaction(transaction);
        Assert.assertNotEquals(0, 1f);
    }
//    @Test
//    public void serviceGetAllTransactionByUserNameSuccess(){
//        Mockito.doReturn(listMock).when(transactionDAO).getAllTransactionByUsername("customer1");
//        List<Transaction> resultList = transactionSO.serviceGetAllTransactionByUsername("customer1");
//        Assert.assertTrue(resultList.size() >= 1);
//
//    }

//    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
//    public void getAllTransactionByUsernameFailureNoUsername() {
//        Transaction transactions = transactionSO.serviceGetAllTransactionByUsername("customer4");
//        Assert.assertNotEquals(transactions.getUsername(), "customer1");
//    }
}
