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
        try {
            return this.transactionDAO.createTransaction(transaction);
        } catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

    @Override
    public Transaction serviceGetAllTransactionByCustomerId(int customerId) {
        try {
            return this.transactionDAO.getAllTransactionByCustomerId(customerId);
        } catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

    @Override
    public Transaction serviceGetAllTransactionByProducerId(int producerId) {
        try {
            return this.transactionDAO.getAllTransactionByProducerId(producerId);
        } catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

}