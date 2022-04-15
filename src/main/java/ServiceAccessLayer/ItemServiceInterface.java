package ServiceAccessLayer;

import entities.Items;

import java.util.List;

public interface ItemServiceInterface {

    Items serviceCreateItems(Items items);


    Items serviceSelectItemsById(int itemId);


    List<Items> serviceSelectAllItems();


    Items serviceUpdateItemsById(Items items);


    int serviceDeleteItemsById(int itemId);

}
