package Assignment9.Level1;

//Create a Book class with attributes title, author, and price. Provide both default and parameterized constructors
 class Book {

    String title;
    String author;
    float price;

    Book() {
        title = "";
        author = "";
        price = 0.0f;
        System.out.println("Default constructor called!!");
    }

    Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Paramatrized constructor called!!");
    }

    public static void main(String[] args) {

        Book ob = new Book();
        Book ob1 = new Book("Empty", "Unknown", 0.0f);

    }
}
