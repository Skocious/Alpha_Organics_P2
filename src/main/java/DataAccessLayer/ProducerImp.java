package DataAccessLayer;

import com.entities.Producer;
import com.utils.DatabaseConnection;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerImp {

    @Override
    public Producer createProducer(Producer producer) {
        try(Connection connection = DatabaseConnection.createConnection()){

            String sql = "insert into producers values(default, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, producer.getFirstName());
            ps.setString(2, producer.getLastName());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();

            rs.next();
            producer.setProducerId(rs.getInt("producer_id"));

            return producer;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Producer selectProducerById(int id) {
        try(Connection connection = DatabaseConnection.createConnection()){
            String sql = "select * from producers where producer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Producer producer = new Producer(
                    rs.getInt("producer_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
            );
            return producer;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    