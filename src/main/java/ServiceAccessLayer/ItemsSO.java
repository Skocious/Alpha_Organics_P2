package ServiceAccessLayer;
import DataAccessLayer.ItemsDAO;
import entities.Items;

import java.util.List;

public interface ItemsSO {
    //create Items
    Items serviceCreateItems(Items items);


    //select Items
    Items serviceSelectItemsById(int itemId);


    //select all Items
    List<Items> serviceSelectAllItems();


    // update Items
    Items serviceUpdateItemsById(Items items);

    //delete Items
    int serviceDeleteItemsById(int itemId);

}
