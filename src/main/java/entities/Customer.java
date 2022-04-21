//package entities;
//
//import java.util.Objects;
//
//public class Customer {
//    int customerId;
//    String customerName;
//    int loginId;
//
//    public Customer(){}
//
//    public Customer(int customerId, String customerName, int loginId) {
//        this.customerId = customerId;
//        this.customerName = customerName;
//        this.loginId = loginId;
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public int getLoginId() {
//        return loginId;
//    }
//
//    public void setLoginId(int loginId) {
//        this.loginId = loginId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return customerId == customer.customerId && loginId == customer.loginId && customerName.equals(customer.customerName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(customerId, customerName, loginId);
//    }
//
//    @Override
//    public String toString() {
//        return "Customer{" +
//                "customerId=" + customerId +
//                ", customerName='" + customerName + '\'' +
//                ", loginId=" + loginId +
//                '}';
//    }
//}
