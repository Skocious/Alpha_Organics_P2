//package DataAccessLayer;
//
//import entities.Items;
//import utilities.DataBaseConnection;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ItemsImp implements ItemsDAO{
//
//    public ItemsImp() {super();}
//
//    @Override
//    public Items createItems(Items items) {
//        try (Connection connection = DataBaseConnection.createConnection()) {
//            String sql = "insert into items values(default, ?, ?)";
//            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, items.getItem_name());
//            ps.setString(2, items.getItem_description());
//            ps.setInt(3, items.getItem_id());
//            ps.setFloat(4, 1);
//            ps.setString(5, items.getStatus());
//            ps.setInt(6, items.getLogin_id());
//            ps.execute();
//            ResultSet rs = ps.getGeneratedKeys();
//            rs.next();
//            items.setItem_id(rs.getInt("itemId"));
//            return items;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public Items selectItemsById(int itemId) {
//        try (Connection connection = DataBaseConnection.createConnection()) {
//            String sql = "select * from items where item_id = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, itemId);
//            ResultSet rs = ps.executeQuery();
//            rs.next();
//            Items items = new Items(
//                    rs.getString("item_name"),
//                    rs.getString("item_description"),
//                    rs.getInt("item_id"),
//                    rs.getInt("price"),
//                    rs.getString("status"),
//                    rs.getInt("login_id")
//            );
//            return items;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public List<Items> selectAllItems() {
//        try (Connection connection = DataBaseConnection.createConnection()) {
//            String sql = "select * from items";
//            Statement s = connection.createStatement();
//            s.execute(sql);
//            ResultSet rs = s.getResultSet();
//            List<Items> items = new ArrayList<>();
//            while (rs.next()) {
//                Items itemList = new Items(
//                        rs.getString("itemName"),
//                        rs.getString("itemDescription"),
//                        rs.getInt("itemId"),
//                        rs.getInt("price"),
//                        rs.getString("status"),
//                        rs.getInt("loginId")
//                );
//                items.add(itemList);
//            }
//                return itemList;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public Items updateItemsById(Items items) {
//        try (Connection connection = DataBaseConnection.createConnection()) {
//            String sql = "update items set itemName = ? itemDescription = ? itemPrice = ? where itemId = ? * ";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, items.getItemName());
//            ps.setString(2, items.getItemDescription());
//            ps.setFloat(4, updateItemsById.getPrice());
//            if (ps.executeUpdate() != 0) {
//                return ps.executeUpdate();
////            else
//                return null;
//            }
//        } catch(SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public int deleteItemsById(int itemId) {
//        return 0;
//    }
//
//
//
//
//
//
//
//
//
//
//    @Override
//    public boolean deleteItemsById(int itemId){
//                    try (Connection connection = DataBaseConnection.createConnection()) {
//                        String sql = "delete from items where itemId = ?";
//                        PreparedStatement ps = connection.prepareStatement(sql);
//                        ps.setInt(1, id);
//                        return ps.executeUpdate();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                        return 0;
//                    }
//}