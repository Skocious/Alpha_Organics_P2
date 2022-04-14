package entities;

import java.util.Objects;

public class Items {
    String itemName;
    String itemDescription;
    int itemId;
    int price;
    //int status;
    //int loginId


    public Items(){}

    public Items(String itemName, String itemDescription, int itemId, int price){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemId = itemId;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemId == items.itemId && price == items.price && Objects.equals(itemName, items.itemName) && Objects.equals(itemDescription, items.itemDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemDescription, itemId, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemId=" + itemId +
                ", price=" + price +
                '}';
    }
}

/* item_name, item_description, item_id, price */