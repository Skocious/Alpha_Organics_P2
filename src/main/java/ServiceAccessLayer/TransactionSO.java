package ServiceAccessLayer;

import entities.Transaction;

import java.util.List;

public interface TransactionSO {

    Transaction serviceCreateTransaction(Transaction transaction);

    Transaction serviceGetAllTransactionByUsername(String Username);
}
