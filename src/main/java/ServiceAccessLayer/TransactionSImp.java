package ServiceAccessLayer;
import DataAccessLayer.TransactionDAO;

import customExceptions.InvalidId;
import entities.Transaction;

import java.util.List;

public class TransactionSImp implements TransactionSO {
    TransactionDAO transactionDAO;

    public TransactionSImp(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }


    @Override
    public Transaction serviceCreateTransaction(Transaction transaction) {
        if (transaction.getItemId() != 0 &&
            transaction.getUsername().length() != 0 &&
            transaction.getUsername().length() <= 20 &&
            transaction.getTransactionAmount() != 0 &&
            transaction.getTransactionAmount() <= 9999
        )
            return this.transactionDAO.createTransaction(transaction);
       else{
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

    @Override
    public List<Transaction> serviceGetAllTransactionByUsername(String Username) {
        if (Username.length() <= 20 &&
            Username.length() != 0)
        {
            return this.transactionDAO.getAllTransactionByUsername(Username);
        } else {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }
}