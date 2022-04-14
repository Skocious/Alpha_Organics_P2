package git add .
        entities;

import java.util.Objects;

public class Producer {
    private int ProducerId;
    private String ProducerName;
    private int LoginId;

    public Producer(){}

    public Producer(int ProducerId, String ProducerName, int LoginId) {
        this.ProducerId = ProducerId;
        this.ProducerName = ProducerName;
        this.LoginId = LoginId;
    }

    public int getProducerId() {
        return ProducerId;
    }

    public void setProducerId(int producerId) {
        ProducerId = producerId;
    }

    public String getProducerName() {
        return ProducerName;
    }

    public void setProducerName(String producerName) {
        ProducerName = producerName;
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
        Producer producer = (Producer) o;
        return ProducerId == producer.ProducerId && LoginId == producer.LoginId && ProducerName.equals(producer.ProducerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProducerId, ProducerName, LoginId);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "ProducerId=" + ProducerId +
                ", ProducerName='" + ProducerName + '\'' +
                ", LoginId=" + LoginId +
                '}';
    }
}


