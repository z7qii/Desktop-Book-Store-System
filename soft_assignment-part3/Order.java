public class Order {
    private String orderId;
    private String bookId;
    private String bookName;
    private String quantity;
    private String customerEmail;
    private Double orderTotal;
    private String paymentType;
    private String orderStatus;
    
  
    public Order(String orderId, String bookId , String bookName , String customerEmail, String quantity , double orderTotal, String paymentType,
            String orderStatus) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.customerEmail = customerEmail;
        this.quantity = quantity;
        this.orderTotal = orderTotal;
        this.paymentType = paymentType;
        this.orderStatus = orderStatus;
    }

    
    public String getQuantity() {
        return quantity;
    }


    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getBookId() {
        return bookId;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public Double getTotal() {
        return orderTotal;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public String getBookName() {
        return bookName;
    }

    

    

}
