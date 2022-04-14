package entities;

import java.util.Objects;

public class Items {
    String item_name;
    String item_description;
    int item_id;
    int price;
    String status;
    int login_id;


    public Items(){}

    public Items(String itemName, String itemDescription, int itemId, int price, String status, int loginId){
        this.item_name = itemName;
        this.item_description = itemDescription;
        this.item_id = itemId;
        this.price = price;
        this.status = status;
        this.login_id = loginId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return item_id == items.item_id && price == items.price && login_id == items.login_id && Objects.equals(item_name, items.item_name) && Objects.equals(item_description, items.item_description) && Objects.equals(status, items.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_name, item_description, item_id, price, status, login_id);
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_name='" + item_name + '\'' +
                ", item_description='" + item_description + '\'' +
                ", item_id=" + item_id +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", login_id=" + login_id +
                '}';
    }
}

/* item_name, item_description, item_id, price */