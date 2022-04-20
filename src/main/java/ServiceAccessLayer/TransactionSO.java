package ServiceAccessLayer;

import entities.Transaction;

import java.util.List;

public interface TransactionSO {

    Transaction serviceCreateTransaction(Transaction transaction);

    Transaction serviceGetAllTransactionByCustomerId(int customerId);

    Transaction serviceGetAllTransactionByProducerId(int producerId);
}
