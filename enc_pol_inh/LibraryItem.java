import java.util.ArrayList;
import java.util.List;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 14; // 14 days for books
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved: " + getTitle());
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved: " + getTitle());
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }

    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved: " + getTitle());
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable;
    }
}

class LibraryManagementSystem {
    public static void displayItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"));
        items.add(new Magazine("M001", "National Geographic", "Various"));
        items.add(new DVD("D001", "Inception", "Christopher Nolan"));

        displayItems(items);
        
        for (LibraryItem item : items) {
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                reservableItem.reserveItem();
                System.out.println("Availability: " + reservableItem.checkAvailability());
                System.out.println();
            }
        }
    }
}
