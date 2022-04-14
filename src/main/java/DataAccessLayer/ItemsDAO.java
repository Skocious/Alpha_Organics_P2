package DataAccessLayer;

import entities.Items;
import utilities.DataBaseConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsImp implements ItemsDAO{

    public ItemsImp() {
        super();
    }


    @Override
    public Items createItems(Items items) {
        try (Connection connection = DataBaseConnection.createConnection()) {

            String sql = "insert into items values(default, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, items.getItemName());
            ps.setString(2, items.getItemDescription());
            // ps.setString(3, items.getItemId(),0);
            ps.setFloat(4, 1);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            items.setItemId(rs.getInt("itemId"));
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Items selectItemsById(int itemId) {
        try(Connection connection = DataBaseConnection.createConnection()){
            String sql = "select * from items where itemId = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Items items = new Items(
                    rs.getString("itemName"),
                    rs.getString("itemDescription"),
                    rs.getInt("itemsId"),
                    rs.getInt("itemPrice")
            );
            return items;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

        @Override
        public List<Items> selectAllItems() {
            try(Connection connection = DataBaseConnection.createConnection()){
                String sql = "select * from items";
                Statement s = connection.createStatement();
                s.execute(sql);
                ResultSet rs = s.getResultSet();
                List<Items> items = new ArrayList<>();
                while(rs.next()){
                    Items itemList = new Items(
                            rs.getString("itemsName"),
                            rs.getString("itemDescription"),
                            rs.getInt("itemId"),
                            rs.getInt("itemPrice")
                    ); // add correct properties

                    items.add(itemList);
                }
                return itemList;

            } catch (SQLException e){
                e.printStackTrace();
                return null;
            }

            @Override
            public Items updateItemsById(Items items) {
                try(Connection connection = DataBaseConnection.createConnection()) {
                    String sql = "update items set itemName = ? itemDescription = ? itemPrice = ? where itemId = ? * ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setString(1, items.getItemName());
                    ps.setString(2, items.getItemDescription());
                    ps.setFloat(4, updateItemsById.getPrice()); // items.getItemPrice()
                    if (ps.executeUpdate() != 0) {
                        return ps.executeUpdate();
                    else;
                    }   catch(SQLException e){
                        e.printStackTrace();
                        return 0;
                    }
                }

                @Override
                public boolean deleteItemsById(int itemId){
                    try (Connection connection = DataBaseConnection.createConnection()) {
                        String sql = "delete from items where itemId = ?";
                        PreparedStatement ps = connection.prepareStatement(sql);
                        ps.setInt(1, id);
                        return ps.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        return 0;
                    }
                }