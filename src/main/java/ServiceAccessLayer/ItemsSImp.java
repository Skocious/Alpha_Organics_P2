package ServiceAccessLayer;
import DataAccessLayer.ItemsDAO;
import customExceptions.InvalidId;
import entities.Items;

import java.util.List;

public class ItemsSImp implements ItemsSO{
    ItemsDAO itemsDAO;

    public ItemsSImp(DataAccessLayer.ItemsImp itemsDAO) {
        this.itemsDAO = itemsDAO;
    }

    @Override //need to add business logic conditions to all below
    public Items serviceCreateItems(Items items) {
        try {
            return this.itemsDAO.createItems(items);
        }catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }


    @Override
    public Items serviceSelectItemsById(int itemId) {
        try {
            return this.itemsDAO.selectItemsById(itemId);
        }catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
    }

    @Override
    public List<Items> serviceSelectAllItems() {
        try {
            return this.itemsDAO.selectAllItems();
        }catch (InvalidId e) {
            throw new InvalidId("Information entered is not correct, please try again.");
        }
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
