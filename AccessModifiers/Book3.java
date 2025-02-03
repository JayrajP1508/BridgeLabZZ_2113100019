package Assignment9.Level1;

public class Book3 {

    public String ISBN;
    protected String title;
    private String author;

    public Book3(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    class EBook {
        public void displayDetails() {
            System.out.println("ISBN: " + ISBN);
            System.out.println("Title: " + title);
        }
    }

    public static void main(String[] args) {
        Book3 book = new Book3("123-4567890123", "Java Programming", "John Doe");
        Book3.EBook ebook =  book.new EBook();
        ebook.displayDetails();

        book.setAuthor("Jane Smith");
        System.out.println("Updated Author: " + book.getAuthor());
    }
}
