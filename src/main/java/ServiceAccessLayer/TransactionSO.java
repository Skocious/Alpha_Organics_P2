package ServiceAccessLayer;

import entities.Transaction;

import java.util.List;

public interface TransactionSO {

    Transaction serviceCreateTransaction(Transaction transaction);

    List<Transaction> serviceGetAllTransactionByUsername(String Username);
}
