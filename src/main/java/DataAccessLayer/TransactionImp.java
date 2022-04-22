package DataAccessLayer;

import entities.Transaction;
import utilities.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionImp implements TransactionDAO{

    public TransactionImp() {super();}

    @Override
    public Transaction createTransaction(Transaction transaction) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "insert into transaction values(default, ?, ?, ?) returning transaction_id";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, transaction.getUsername());
            ps.setFloat(2, transaction.getTransactionAmount());
            ps.setInt(3, transaction.getItemId());
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
    public Transaction getAllTransactionByUsername(String Username) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from transaction where login_name = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, Username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Transaction transaction = new Transaction(
                    rs.getInt("transaction_id"),
                    rs.getString("login_name"),
                    rs.getFloat("transaction_amount"),
                    rs.getInt("item_id")
            );
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

