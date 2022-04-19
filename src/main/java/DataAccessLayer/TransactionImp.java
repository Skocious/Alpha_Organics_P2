package DataAccessLayer;

import entities.Transaction;
import utilities.DataBaseConnection;

import java.sql.*;

public class TransactionImp implements TransactionDAO{

    public TransactionImp() {super();}

    @Override
    public Transaction createTransaction(Transaction transaction) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "insert into transaction values(default, ?, ?, ?, ?) returning transaction_id";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, transaction.getCustomerId());
            ps.setInt(2, transaction.getProducerId());
            ps.setFloat(3, transaction.getTransactionAmount());
            ps.setInt(4, transaction.getItemId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            transaction.setTransactionId(rs.getInt("transaction_id"));
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Transaction getAllTransactionByCustomerId(int customerId) {
        return null;
    }

    @Override
    public Transaction getAllTransactionByProducerId(int producerId) {
        return null;
    }
}
