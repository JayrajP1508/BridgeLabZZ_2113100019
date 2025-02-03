class Product {
    private static double discount = 0.0;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;
    private static int idCounter = 1;

    public Product(String productName, double price, int quantity) {
        this.productID = idCounter++;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public double getFinalPrice() {
        return price * quantity * (1 - discount / 100);
    }

    public void displayProductDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Price: " + getFinalPrice());
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 50000, 1);
        Product p2 = new Product("Mouse", 1500, 2);

        Product.updateDiscount(10);

        if (p1 instanceof Product) {
            p1.displayProductDetails();
        }
        System.out.println();
        if (p2 instanceof Product) {
            p2.displayProductDetails();
        }
    }
}
