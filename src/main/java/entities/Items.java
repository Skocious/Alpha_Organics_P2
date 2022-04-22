package entities;

import java.util.Objects;

public class Items {
    private int itemId;
    private String Username;
    private String itemName;
    private String itemDescription;
    private float price;



    public Items(){}

    public Items(int itemId, String Username, String itemName, String itemDescription, float price){
        this.itemId = itemId;
        this.Username = Username;
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

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
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
        return itemId == items.itemId && Float.compare(items.price, price) == 0 && Username.equals(items.Username) && itemName.equals(items.itemName) && itemDescription.equals(items.itemDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, Username, itemName, itemDescription, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", Username='" + Username + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", price=" + price +
                '}';
    }
}