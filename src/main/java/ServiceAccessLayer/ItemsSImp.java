package ServiceAccessLayer;
import DataAccessLayer.ItemsDAO;
import DataAccessLayer.ItemsImp;
import customExceptions.InvalidId;
import entities.Items;
import java.util.HashMap;
import java.util.List;

public class ItemsSImp implements ItemsSO{
    public ItemsDAO itemsDAO;

    public ItemsSImp(ItemsDAO itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Override
    public Items serviceCreateItems(Items items) {
        if(items.getItem_name().length() <= 20 &&
                 items.getItem_description().length() <= 100 &&
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
        HashMap< Integer, String > resultMap = new HashMap<>();
        for (int i = 0; i < resultList.size(); i++) {
            Items currentTest = resultList.get(i);
            resultMap.put(currentTest.getItem_id(), currentTest.getItem_name());
        }
        return null;
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
//package ServiceAccessLayer;
//import DataAccessLayer.ItemsDAO;
//import customExceptions.InvalidId;
//import entities.Items;
//
//import java.util.List;
//
//public class ItemsSImp implements ItemsSO{
//    ItemsDAO itemsDAO;
//
//    public ItemsSImp(ItemsDAO itemsDAO) {
//        this.itemsDAO = itemsDAO;
//    }
//
//    @Override //need to add business logic conditions to all below
//    public Items serviceCreateItems(Items items) {
//        try {
//            return this.itemsDAO.createItems(items);
//        }catch (InvalidId e) {
//            throw new InvalidId("Information entered is not correct, please try again.");
//        }
//    }
//
//
//    @Override
//    public Items serviceSelectItemsById(int itemId) {
//        try {
//            return this.itemsDAO.selectItemsById(itemId);
//        }catch (InvalidId e) {
//            throw new InvalidId("Information entered is not correct, please try again.");
//        }
//    }
//
//    @Override
//    public List<Items> serviceSelectAllItems() {
//        try {
//            return this.itemsDAO.selectAllItems();
//        }catch (InvalidId e) {
//            throw new InvalidId("Information entered is not correct, please try again.");
//        }
//    }
//
//    @Override
//    public Items serviceUpdateItemsById(Items items) {
//        try {
//            return this.itemsDAO.updateItemsById(items);
//        }catch (InvalidId e) {
//            throw new InvalidId("Information entered is not correct, please try again.");
//        }
//    }
//
//    @Override
//    public int serviceDeleteItemsById(int itemId) {
//        try {
//            return this.itemsDAO.deleteItemsById(itemId);
//        }catch (InvalidId e) {
//            throw new InvalidId("Information entered is not correct, please try again.");
//        }
//    }
//}
