package entities;

import java.util.Objects;

public class Items {
    private int itemId;
    private int producerId;
    private String itemName;
    private String itemDescription;
    private float price;



    public Items(){}

    public Items(int itemId, int producerId, String itemName, String itemDescription, float price){
        this.itemId = itemId;
        this.producerId = producerId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return itemId == items.itemId && producerId == items.producerId && Float.compare(items.price, price) == 0 && itemName.equals(items.itemName) && itemDescription.equals(items.itemDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, producerId, itemName, itemDescription, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", producerId=" + producerId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", price=" + price +
                '}';
    }
}




/* itemName, itemDescription, itemId, price */


