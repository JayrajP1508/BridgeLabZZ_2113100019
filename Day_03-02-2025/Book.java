class Book{
    static String libraryName = "City Library";
    final String isbn;
    String title;
    String author;
    
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
    
    void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        }
    }
    
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", "123-4567890123");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "456-7890123456");
        
        book1.displayDetails();
        book2.displayDetails();
        
        displayLibraryName();
    }
}
