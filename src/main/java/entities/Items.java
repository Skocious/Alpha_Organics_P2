package entities;

import java.util.Objects;

public class Items {
    private int item_id;
    private int producer_id;
    private String item_name;
    private String item_description;
    private int price;



    public Items(){}

    public Items(int itemId, int producer_id, String itemName, String itemDescription, int price){
        this.item_id = itemId;
        this.producer_id = producer_id;
        this.item_name = itemName;
        this.item_description = itemDescription;
        this.price = price;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getProducer_id() {
        return producer_id;
    }

    public void setProducer_id(int producer_id) {
        this.producer_id = producer_id;
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
        return item_id == items.item_id && producer_id == items.producer_id && price == items.price && Objects.equals(item_name, items.item_name) && Objects.equals(item_description, items.item_description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, producer_id, item_name, item_description, price);
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_id=" + item_id +
                ", producer_id=" + producer_id +
                ", item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                ", price=" + price +
                '}';
    }

}

/* item_name, item_description, item_id, price */