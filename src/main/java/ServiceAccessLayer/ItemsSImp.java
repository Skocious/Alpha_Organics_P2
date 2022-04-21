package ServiceAccessLayer;
import DataAccessLayer.ItemsDAO;
import DataAccessLayer.ItemsImp;
import customExceptions.InvalidId;
import entities.Items;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class ItemsSImp implements ItemsSO{
    public ItemsDAO itemsDAO;

    public ItemsSImp(DataAccessLayer.ItemsImp itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Override
    public Items serviceCreateItems(Items items) {
        if(      items.getItemName().length() <= 20 &&
                 items.getItemDescription().length() <= 100 &&
                 items.getPrice() <= 9999 &&
                 items.getPrice() != 0)
            return this.itemsDAO.createItems(items);
         else {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

    @Override
    public Items serviceSelectItemsById(int itemId) {
        Items test = itemsDAO.selectItemsById(itemId);
        return test;
    }

    @Override
    public List<Items> serviceSelectAllItems() {
        List<Items> resultList = itemsDAO.selectAllItems();
        return resultList;
    }

    @Override
    public Items serviceUpdateItemsById(Items items) {
        try {
            return this.itemsDAO.updateItemsById(items);
        }catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

    @Override
    public int serviceDeleteItemsById(int itemId) {
        try {
            return this.itemsDAO.deleteItemsById(itemId);
        }catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }
}
