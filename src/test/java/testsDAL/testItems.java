package testsDAL;
import DataAccessLayer.ItemsImp;
import entities.Items;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

//        int item_id;
//        int producer_id;
//        String item_name;
//        String item_description;
//        int price;



public class testItems {

    ItemsImp itemsDAO = new ItemsImp();

    @Test
    public void createItemsSuccess(){
        Items newItem = new Items(0, 1, "monkey", "chimpanzee", 1000);
        Items resultNewItems = itemsDAO.createItems(newItem);
        Assert.assertNotEquals(resultNewItems.getItem_id(), 4);

    }

    @Test
    public void selectItemsByIdSuccess(){
        Items items = itemsDAO.selectItemsById(2);
        Assert.assertEquals(items.getItem_id(), 2);
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
        Items items = new Items(10, 5, "apple", "gala", 2);
        Items result = itemsDAO.updateItemsById(items);
        Assert.assertTrue(items.getItem_id() != 0);
    }
}