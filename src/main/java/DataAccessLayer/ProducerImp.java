package DataAccessLayer;
import utilities.DataBaseConnection;
import entities.Producer;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProducerImp implements ProducerDAO {

    public ProducerImp() {super();}

    @Override
    public Producer selectProducerId(int ProducerId, String ProducerName, int LoginId) {
        try(Connection connection = DataBaseConnection.createConnection()){
            String sql = "select * from producer where producer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,ProducerId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Producer producer = new Producer(
                    rs.getInt("producer_id"),
                    rs.getString("producer_name"),
                    rs.getInt("login_id")
            );
            return producer;
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
    