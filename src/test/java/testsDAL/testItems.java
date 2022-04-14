package testsDAL;
import DataAccessLayer.ItemsImp;
import entities.Items;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.List;

//        String item_name;
//        String item_description;
//        int item_id;
//        int price;
//        String status;
//        int login_id;



public class testItems {

    ItemsImp itemsDAO = new ItemsImp();

    @Test
    public void createItemsSuccess(){
        Items newItem = new Items("apple", "gala", 0, 1, "available", 1 );
        Items resultNewItems = itemsDAO.createItems(newItem);
        Assert.assertNotEquals(resultNewItems.getItem_id(), 1);

    }

    @Test
    public void selectItemsByIdSuccess(){
        Items items = itemsDAO.selectItemsById(-1);
        Assert.assertEquals(items.getItem_id(), -1);
    }

    //check import
    @Test
    public void getAllItemsByIdSuccess() {
        List<Items> items = itemsDAO.selectAllItems();
        int listLength = items.size();
        Assert.assertTrue(items.size() >= 1);

    }

    @Test
    public void updateItemsByIdSuccess(){
        Items items = new Items("apple", "gala", 1, 1, "available", 1 );
        Items result = itemsDAO.updateItemsById(items);
        Assert.assertTrue(items.getItem_id() != 0);
    }
}

