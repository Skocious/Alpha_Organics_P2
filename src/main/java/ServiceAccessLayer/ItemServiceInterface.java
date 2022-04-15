package ServiceAccessLayer;
import DataAccessLayer.ItemsDAO;
import entities.Items;

import java.util.List;

public interface ItemSO extends ItemsDAO {

    Items serviceCreateItems(Items items);


    Items serviceSelectItemsById(int itemId);


    List<Items> serviceSelectAllItems();


    Items serviceUpdateItemsById(Items items);


    int serviceDeleteItemsById(int itemId);

}
