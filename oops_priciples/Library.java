package Assignment11;

import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> book;

    Library(String name) {
        this.name = name;
        this.book = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.book.add(book);
    }

    public void showBooks() {
        System.out.println("Books in " + name + " : ");
        for (Book b : book) {
            System.out.println("Title: " + b.getTitle());
            System.out.println("Author: " + b.getAuthor());
        }
    }


}

class Book {
    private String title;
    private String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}

class Main5 {
    public static void main(String[] args) {
        Library library = new Library("Central Library");

        Book book1 = new Book("Java Programming", "Herbert Schildt");
        Book book2 = new Book("Data Structures", "Robert Sedgewick");

        library.addBook(book1);
        library.addBook(book2);

        library.showBooks();
    }
}




