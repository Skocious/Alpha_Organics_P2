package DataAccessLayer;

import entities.Transaction;
import java.util.List;

public interface TransactionDAO {

    Transaction createTransaction(Transaction transaction);

    List<Transaction> getAllTransactionByUsername(String Username);

}