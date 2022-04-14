import DataAccessLayer.ItemsImp;
import entities.Items;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class testItems {

    ItemsImp itemsDAO = new ItemsImp();

    @Test
    public void createItemsSuccess(){
        Items newItem = new Items("apple", "gala", 0, 1 );
        Items resultNewItems = itemsDAO.createItems(newItem);
        Assert.assertNotEquals(resultNewItems.getItemId(), 0);

    }

    @Test
    public void selectItemsByIdSuccess(){
        Items items = itemsDAO.selectItemsById(-1);
        Assert.assertEquals(items.getItemId(), -1);
    }

    //check import
    @Test
    public void getAllItemsByIdSuccess(){
        List<Items> items = itemsDAO.selectAllItems();
        int listLength = items.size();
        Assert.assertTrue(items.size() >= 1);


        @Test
        public void updateItemsByIdSuccess(){
            Items items = new Items("apple", "brayburn", 0, 1)
            Assert.assertEquals();
        }
    }
}
