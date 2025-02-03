package Assignment9.Level1;

public class Product {

    String productName;
    float price;
    static int totalProducts=0;

    Product(String productName, float price){

        this.productName=productName;
        this.price=price;
        totalProducts+=1;

    }
    void displayProductDetails() {
        System.out.println("Product Name:" + productName);
        System.out.println("Price: " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total No. of Products created: "+ totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000.99f);
        Product p2 = new Product("Smartphone", 25000.50f);
        Product p3 = new Product("Headphones", 1999.99f);
        Product p4 = new Product("Smartwatch", 7999.49f);
        Product p5 = new Product("Tablet", 32999.75f);
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }

}
