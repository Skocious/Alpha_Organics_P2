package entities;

import java.util.Objects;

public class Transaction {
    private int transactionId;
    private int customerId;
    private int producerId;
    private float transactionAmount;

    public Transaction(){}

    public Transaction(int transactionId, int customerId, int producerId, float transactionAmount) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.producerId = producerId;
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public float getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(float transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId && customerId == that.customerId && producerId == that.producerId && Float.compare(that.transactionAmount, transactionAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, customerId, producerId, transactionAmount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", customerId=" + customerId +
                ", producerId=" + producerId +
                ", transactionAmount=" + transactionAmount +
                '}';
    }
}