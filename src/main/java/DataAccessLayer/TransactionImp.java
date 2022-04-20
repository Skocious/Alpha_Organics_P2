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
            String sql = "insert into transaction values(default, ?, ?, ?, ?) returning transactions_id";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, transaction.getCustomerId());
            ps.setInt(2, transaction.getProducerId());
            ps.setFloat(3, transaction.getTransactionAmount());
            ps.setInt(4, transaction.getItemId());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            transaction.setTransactionId(rs.getInt("transactions_id"));
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Transaction getAllTransactionByCustomerId(int customerId) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from transaction where customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Transaction transaction = new Transaction(
                    rs.getInt("transactions_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("producer_id"),
                    rs.getFloat("transaction_amount"),
                    rs.getInt("item_id")
            );
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Transaction getAllTransactionByProducerId(int producerId) {
        try (Connection connection = DataBaseConnection.createConnection()) {
            String sql = "select * from transaction where producer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, producerId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Transaction transaction = new Transaction(
                    rs.getInt("transactions_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("producer_id"),
                    rs.getFloat("transaction_amount"),
                    rs.getInt("item_id")
            );
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public List<Transaction> getAllTransactionByCustomerId() {
//        try (Connection connection = DataBaseConnection.createConnection()) {
//        String sql = "select * from transaction where customer_id = ?";
//        Statement s = connection.createStatement();
//            s.execute(sql);
//            ResultSet rs = s.getResultSet();
//            List<Transaction> transactions = new ArrayList<>();
//            while (rs.next()) {
//                Transaction transactionList = new Transaction(
//                            rs.getInt("customer_id"),
//                            rs.getInt("transaction_id"),
//                            rs.getInt("producer_id"),
//                            rs.getFloat("transaction_amount"),
//                            rs.getInt("item_id")
//                );
//                transactions.add(transactionList);
//            }
//            return transactions;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    @Override
//    public List<Transaction> getAllTransactionByProducerId() {
//        try (Connection connection = DataBaseConnection.createConnection()) {
//            String sql = "select * from transaction where producer_id = ?";
//            Statement s = connection.createStatement();
//            s.execute(sql);
//            ResultSet rs = s.getResultSet();
//            List<Transaction> transactions = new ArrayList<>();
//            while (rs.next()) {
//                Transaction transactionList = new Transaction(
//                        rs.getInt("customer_id"),
//                        rs.getInt("transaction_id"),
//                        rs.getInt("producer_id"),
//                        rs.getFloat("transaction_amount"),
//                        rs.getInt("item_id")
//                );
//                transactions.add(transactionList);
//            }
//            return transactions;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
