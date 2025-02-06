package Assignment11;

import java.util.ArrayList;

class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return productName + " - $" + price;
    }
}

class Order {
    private int orderId;
    private Customer2 customer;
    private ArrayList<Product> products;

    public Order(int orderId, Customer2 customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer.getCustomerName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

class Customer2 {
    private String customerName;
    private ArrayList<Order> orders;

    public Customer2(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public String getCustomerName() {
        return customerName;
    }
}

class Main6 {
    public static void main(String[] args) {
        Customer2 customer = new Customer2("Alice Johnson");

        Product product1 = new Product("Laptop", 1200.50);
        Product product2 = new Product("Headphones", 200.75);

        Order order = new Order(101, customer);
        order.addProduct(product1);
        order.addProduct(product2);

        customer.placeOrder(order);

        order.displayOrder();
    }
}



