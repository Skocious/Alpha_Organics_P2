package entities;

import java.util.Objects;

public class Transaction {
    private int transactionId;
    private String Username;
    private float transactionAmount;
    private int itemId;


    public Transaction(){}

    public Transaction(int transactionId, String Username, float transactionAmount, int itemId) {
        this.transactionId = transactionId;
        this.Username = Username;
        this.transactionAmount = transactionAmount;
        this.itemId = itemId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && Float.compare(that.transactionAmount, transactionAmount) == 0 && itemId == that.itemId && Username.equals(that.Username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, Username, transactionAmount, itemId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", Username='" + Username + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", itemId=" + itemId +
                '}';
    }
}