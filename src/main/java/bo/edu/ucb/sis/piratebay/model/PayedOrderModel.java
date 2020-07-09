package bo.edu.ucb.sis.piratebay.model;

public class PayedOrderModel {
    private Integer orderId;
    private String date;
    private String customer;
    private String address;

    public PayedOrderModel() {
    }

    public PayedOrderModel(Integer orderId, String date, String customer, String address) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", date='" + date + '\'' +
                ", customer='" + customer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
