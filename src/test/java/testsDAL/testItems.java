package testsDAL;
import DataAccessLayer.ItemsImp;
import entities.Items;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

//        int item_id;
//        int producer_id;
//        String item_name;
//        String item_description;
//        int price;



public class testItems {

    ItemsImp itemsDAO = new ItemsImp();

    @Test
    public void createItemsSuccess() {
        Items newItem = new Items(0, "customer1", "monkey", "chimpanzee", 1000);
        Items resultNewItems = itemsDAO.createItems(newItem);
        Assert.assertNotEquals(resultNewItems.getItemId(), 0);

    }

//    @Test connection to db failure on sl mock
//    public void createItemsFailure() {
//        Items newItem = new Items(0, 1, "grapes", "chimpanzee", 10000);
//        Items resultNewItems = itemsDAO.createItems(newItem);
//        Assert.expectThrows(SQLException);
//    }

    @Test
    public void selectItemsByIdSuccess() {
        Items items = itemsDAO.selectItemsById(1);
        Assert.assertEquals(items.getItemId(), 1);
    }

//    @Test
//    public void selectItemsByIdFailure() {
//        Items items = itemsDAO.selectItemsById(4);
//        Assert.assertFalse(items.getItem_id()== -1);
//    }
//    //check import

    @Test
    public void updateItemsByIdSuccess() {
        Items items = new Items(10, "customer1", "grape", "gala", 2);
        Items result = itemsDAO.updateItemsById(items);
        Assert.assertTrue(items.getItemName() == "grape");
    }

//    @Test
//    public void updateItemsByIdFailure() {
//        Items items = new Items(10, 5, "apple", "gala", 2);
//        Items result = itemsDAO.updateItemsById(items);
//        Assert.assertFalse(items.getItem_id() == 0);
//    }


    @Test
    public void getAllItemsByIdSuccess() {
        List<Items> items = itemsDAO.selectAllItems();
        int listLength = items.size();
        Assert.assertTrue(items.size() >= 1);

    }

//    @Test
//    public void getAllItemsByIdFailure() {
//        List<Items> items = itemsDAO.selectAllItems();
//        int listLength = items.size();
//        Assert.assertFalse(items.size() <= 0);
//
//    }

//    @Test
//    public void deleteItemsByIdSuccess(){
//        Items items = itemsDAO.deleteItemsById(items);
//        Assert.;
//
//    }
}