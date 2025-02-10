import java.util.ArrayList;
import java.util.List;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    void applyDiscount(double discountPercentage);
    String getDiscountDetails();
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge;

    public NonVegItem(String itemName, double price, int quantity, double additionalCharge) {
        super(itemName, price, quantity);
        this.additionalCharge = additionalCharge;
    }

    public double calculateTotalPrice() {
        return (getPrice() + additionalCharge) * getQuantity();
    }

    public void applyDiscount(double discountPercentage) {
        double discountAmount = (getPrice() * getQuantity()) * (discountPercentage / 100);
        double totalPrice = calculateTotalPrice();
        totalPrice -= discountAmount;
        System.out.println("Total price after discount: " + totalPrice);
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: Apply discounts based on total price.";
    }
}

class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> foodItems) {
        for (FoodItem item : foodItems) {
            System.out.println(item.getItemDetails());
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(10);
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(new VegItem("Paneer Tikka", 200, 2));
        foodItems.add(new NonVegItem("Chicken Biryani", 300, 1, 50));

        processOrder(foodItems);
    }
}
