package ServiceAccessLayer;

import entities.Transaction;

public interface TransactionSO {

    Transaction serviceCreateTransaction(Transaction transaction);

    Transaction serviceGetAllTransactionByCustomerId(int customerId);

    Transaction serviceGetAllTransactionByProducerId(int producerId);

}
