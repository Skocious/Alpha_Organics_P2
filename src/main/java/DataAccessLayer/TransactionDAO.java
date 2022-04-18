package DataAccessLayer;

import entities.Transaction;

public interface TransactionDAO {

    Transaction createTransaction(Transaction transaction);

    Transaction getAllTransactionByCustomerId(int customerId);

    Transaction getAllTransactionByProducerId(int producerId);
}