package src.Samantha.Entities;

import java.util.Objects;

public class Consumer {
    private int ConsumerId;
    private String ConsumerUsername;
    private String ConsumerPassword;
    private int LoginId;

    public Consumer(){}

    public Consumer(int ConsumerId, String ConsumerUsername, String ConsumerPassword, int LoginId) {
        this.ConsumerId = ConsumerId;
        this.ConsumerUsername = ConsumerUsername;
        this.ConsumerPassword = ConsumerPassword;
        this.LoginId = LoginId;
    }

    public int getConsumerId() {
        return ConsumerId;
    }

    public void setConsumerId(int consumerId) {
        ConsumerId = consumerId;
    }

    public String getConsumerUsername() {
        return ConsumerUsername;
    }

    public void setConsumerUsername(String consumerUsername) {
        ConsumerUsername = consumerUsername;
    }

    public String getConsumerPassword() {
        return ConsumerPassword;
    }

    public void setConsumerPassword(String consumerPassword) {
        ConsumerPassword = consumerPassword;
    }

    public int getLoginId() {
        return LoginId;
    }

    public void setLoginId(int loginId) {
        LoginId = loginId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumer consumer = (Consumer) o;
        return ConsumerId == consumer.ConsumerId && LoginId == consumer.LoginId && ConsumerUsername.equals(consumer.ConsumerUsername) && ConsumerPassword.equals(consumer.ConsumerPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ConsumerId, ConsumerUsername, ConsumerPassword, LoginId);
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "ConsumerId=" + ConsumerId +
                ", ConsumerUsername='" + ConsumerUsername + '\'' +
                ", ConsumerPassword='" + ConsumerPassword + '\'' +
                ", LoginId=" + LoginId +
                '}';
    }
}




