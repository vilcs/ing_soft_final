package bo.edu.ucb.sis.piratebay.model;

public class ReadyOrderModel {
    private Integer orderId;
    private String customer;
    private String date;
    private String requestDate;

    public ReadyOrderModel() {
    }

    public ReadyOrderModel(Integer orderId, String customer, String date, String requestDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.date = date;
        this.requestDate = requestDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "ReadyOrderModel{" +
                "orderId=" + orderId +
                ", customer='" + customer + '\'' +
                ", date='" + date + '\'' +
                ", requestDate='" + requestDate + '\'' +
                '}';
    }
}
