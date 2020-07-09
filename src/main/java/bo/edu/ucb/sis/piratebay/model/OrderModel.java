package bo.edu.ucb.sis.piratebay.model;

public class OrderModel {
    private Integer orderId;
    private String date;
    private String customer;

    public OrderModel() {
    }

    public OrderModel(Integer orderId, String date, String customer) {
        this.orderId = orderId;
        this.date = date;
        this.customer = customer;
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

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", date='" + date + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }

    public static class PayedModel extends OrderModel{
        private String address;

        public PayedModel() {
        }

        public PayedModel(String address) {
            this.address = address;
        }

        public PayedModel(Integer orderId, String date, String customer, String address) {
            super(orderId, date, customer);
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "PayedModel{" +
                    "orderId=" + getOrderId() +
                    ", date='" + getDate() + '\'' +
                    ", customer='" + getCustomer() + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    class ReadyModel extends OrderModel{
        private String requestDate;

        public ReadyModel(String requestDate) {
            this.requestDate = requestDate;
        }

        public ReadyModel(Integer orderId, String date, String customer, String requestDate) {
            super(orderId, date, customer);
            this.requestDate = requestDate;
        }

        public String getRequestDate() {
            return requestDate;
        }

        public void setRequestDate(String requestDate) {
            this.requestDate = requestDate;
        }

        @Override
        public String toString() {
            return "ReadyModel{" +
                    "orderId=" + orderId +
                    ", date='" + date + '\'' +
                    ", customer='" + customer + '\'' +
                    ", requestDate='" + requestDate + '\'' +
                    '}';
        }
    }

    class DispatchedModel extends OrderModel {
        private String courierRecDate;

        public DispatchedModel(String courierRecDate) {
            this.courierRecDate = courierRecDate;
        }

        public DispatchedModel(Integer orderId, String date, String customer, String courierRecDate) {
            super(orderId, date, customer);
            this.courierRecDate = courierRecDate;
        }

        public String getCourierRecDate() {
            return courierRecDate;
        }

        public void setCourierRecDate(String courierRecDate) {
            this.courierRecDate = courierRecDate;
        }

        @Override
        public String toString() {
            return "DispatchedModel{" +
                    "orderId=" + orderId +
                    ", date='" + date + '\'' +
                    ", customer='" + customer + '\'' +
                    ", courierRecDate='" + courierRecDate + '\'' +
                    '}';
        }
    }

    class DeliveredModel extends OrderModel {
        private String courierRecDate;
        private String customerRecDate;

        public DeliveredModel(String courierRecDate, String customerRecDate) {
            this.courierRecDate = courierRecDate;
            this.customerRecDate = customerRecDate;
        }

        public DeliveredModel(Integer orderId, String date, String customer, String courierRecDate, String customerRecDate) {
            super(orderId, date, customer);
            this.courierRecDate = courierRecDate;
            this.customerRecDate = customerRecDate;
        }

        public String getCourierRecDate() {
            return courierRecDate;
        }

        public String getCustomerRecDate() {
            return customerRecDate;
        }

        public void setCustomerRecDate(String customerRecDate) {
            this.customerRecDate = customerRecDate;
        }

        @Override
        public String toString() {
            return "DeliveredModel{" +
                    "orderId=" + orderId +
                    ", date='" + date + '\'' +
                    ", customer='" + customer + '\'' +
                    ", courierRecDate='" + courierRecDate + '\'' +
                    ", customerRecDate='" + customerRecDate + '\'' +
                    '}';
        }
    }
}
