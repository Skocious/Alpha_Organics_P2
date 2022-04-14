package entities;

import java.util.Objects;

public class Items {
    String item_name;
    String item_description;
    int item_id;
    int price;



    public Items(){}

    public Items(String itemName, String itemDescription, int itemId, int price){
        this.item_name = itemName;
        this.item_description = itemDescription;
        this.item_id = itemId;
        this.price = price;

    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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
        return item_id == items.item_id && price == items.price && Objects.equals(item_name, items.item_name) && Objects.equals(item_description, items.item_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_name, item_description, item_id, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                ", item_id=" + item_id +
                ", price=" + price +
                '}';
    }
}

/* item_name, item_description, item_id, price */