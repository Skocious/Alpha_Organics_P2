package ServiceAccessLayer;
import DataAccessLayer.ItemsDAO;
import DataAccessLayer.ItemsImp;
import customExceptions.InvalidId;
import entities.Items;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class ItemsSImp implements ItemsSO {
    public ItemsDAO itemsDAO;

    public ItemsSImp(DataAccessLayer.ItemsImp itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Override
    public Items serviceCreateItems(Items items) {
        if (items.getItemName().length() <= 20 &&
                items.getItemDescription().length() <= 100 &&
                items.getPrice() <= 9999 &&
                items.getPrice() != 0)
            return this.itemsDAO.createItems(items);
        else {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
//            if(items.getItem_name().length() <= 20){
//                throw new InvalidId("Item name too long");
//            }else if(items.getItem_description().length() <= 100){
//                throw new InvalidId("Item description too long");
//            }else if (items.getPrice() <= 9999){
//                throw new InvalidId("Item price is high");
//            }else if (items.getPrice() <= 0){
//                throw new InvalidId("Item price is high");
//            }else if(items.getItem_name().length() == 0 ||
//                items.getItem_description().length() == 0 ||
//                items.getPrice() == 0) {
//                return this.itemsDAO.createItems(items);
//            }
//            else {
//                  throw new InvalidId("Information entered is not correct, please try again.");
//                }
    }

    @Override
    public Items serviceSelectItemsById(int itemId) {
        Items test = itemsDAO.selectItemsById(itemId);
        if (test == null) {
            throw new InvalidId("Please enter a valid itemId");
        } else {
            return test;
        }
    }

    @Override
    public List<Items> serviceSelectAllItems() {
        List<Items> resultList = itemsDAO.selectAllItems();
        if (resultList == null) {
            throw new InvalidId("No items to be sold");
        } else {
            return resultList;
        }
    }

    @Override
    public Items serviceUpdateItemsById(Items items) {
        if (items.getItemName().length() > 20) {
            throw new InvalidId("Item Name too long");
        } else if (items.getItemDescription().length() > 100) {
            throw new InvalidId("Item description too long");
        } else if (items.getPrice() > 9999) {
            throw new InvalidId("Item price is too high");
        } else if (items.getPrice() <= 0) {
            throw new InvalidId("we dont offer free");
        }else
             {
            return this.itemsDAO.updateItemsById(items);
        }

    }


//        Items test = itemsDAO.updateItemsById(items);
//        if (test == null){
//            throw new InvalidId("Please update info")
//        }else {
//            return test;
//        }


    @Override
    public int serviceDeleteItemsById(int itemId) {
        int result = itemsDAO.deleteItemsById(itemId);
        if (result == 0){
            throw new InvalidId("No item for the itemid");
        }else {
            return 1;
        }

    }
}
