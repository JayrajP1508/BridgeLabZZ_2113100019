import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String getCategory();
}

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Book";
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}

class Gadget extends Product {
    public Gadget(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Gadget";
    }
}

class ProductCatalog<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getAllProducts() {
        return products;
    }
}

class MarketplaceUtility {
    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }

    public static void displayProducts(List<? extends Product> products) {
        for (Product product : products) {
            System.out.println(product.getCategory() + ": " + product.getName() + " - $" + product.getPrice());
        }
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog<Book> bookCatalog = new ProductCatalog<>();
        bookCatalog.addProduct(new Book("Java Programming", 50));
        bookCatalog.addProduct(new Book("Data Structures", 40));

        ProductCatalog<Clothing> clothingCatalog = new ProductCatalog<>();
        clothingCatalog.addProduct(new Clothing("T-Shirt", 20));
        clothingCatalog.addProduct(new Clothing("Jeans", 50));

        ProductCatalog<Gadget> gadgetCatalog = new ProductCatalog<>();
        gadgetCatalog.addProduct(new Gadget("Smartphone", 500));
        gadgetCatalog.addProduct(new Gadget("Smartwatch", 150));

        System.out.println("Before Discount:");
        MarketplaceUtility.displayProducts(bookCatalog.getAllProducts());
        MarketplaceUtility.displayProducts(clothingCatalog.getAllProducts());
        MarketplaceUtility.displayProducts(gadgetCatalog.getAllProducts());

        MarketplaceUtility.applyDiscount(bookCatalog.getAllProducts().get(0), 10);
        MarketplaceUtility.applyDiscount(clothingCatalog.getAllProducts().get(1), 15);
        MarketplaceUtility.applyDiscount(gadgetCatalog.getAllProducts().get(0), 5);

        System.out.println("\nAfter Discount:");
        MarketplaceUtility.displayProducts(bookCatalog.getAllProducts());
        MarketplaceUtility.displayProducts(clothingCatalog.getAllProducts());
        MarketplaceUtility.displayProducts(gadgetCatalog.getAllProducts());
    }
}
