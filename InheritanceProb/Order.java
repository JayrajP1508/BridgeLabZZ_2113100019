public class Main {
    public static void main(String[] args) {
        Order order = new Order("O1001", "2025-02-06");
        ShippedOrder shippedOrder = new ShippedOrder("O4548", "2025-01-02", "TRK12345");
        DeliveredOrder deliveredOrder = new DeliveredOrder("O8983", "2025-01-31", "TRK67890", "2025-02-06");
        
        System.out.println(order.getOrderStatus());
        System.out.println(shippedOrder.getOrderStatus());
        System.out.println(deliveredOrder.getOrderStatus());
    }
}

class Order {
    protected String orderId;
    protected String orderDate;
    
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
    public String getOrderStatus() {
        return "Order placed";
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;
    
    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    
    @Override
    public String getOrderStatus() {
        return "Order shipped with tracking number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;
    
    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    
    @Override
    public String getOrderStatus() {
        return "Order delivered on: " + deliveryDate;
    }
}


