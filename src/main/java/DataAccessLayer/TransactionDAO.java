package DataAccessLayer;

import entities.Transaction;

import java.util.List;

public interface TransactionDAO {

    Transaction createTransaction(Transaction transaction);

    Transaction getAllTransactionByCustomerId(int customerId);

    Transaction getAllTransactionByProducerId(int producerId);
}