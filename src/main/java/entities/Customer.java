package entities;

import java.util.Objects;

public class Customer {
    int customer_id;
    String customer_name;
    int login_id;

    public Customer(){}

    public Customer(int customer_id, String customer_name, int login_id) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.login_id = login_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
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
        Customer customer = (Customer) o;
        return customer_id == customer.customer_id && login_id == customer.login_id && Objects.equals(customer_name, customer.customer_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_id, customer_name, login_id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", login_id=" + login_id +
                '}';
    }
}
