package Assignment9.Level1;

public class Book2 {
    String title;
    String  author;
    float price;
    boolean availability;

    Book2(){
        title="";
        author="";
        price=0.0f;
        availability=true;
    }
    Book2(String title, String author,float price , boolean availability){
        this.title=title;
        this.author=author;
        this.price=price;
        this.availability=availability;
    }

    void borrowBook(){
        if(!availability){
            System.out.println("Book is not available");
            return ;
        }
        System.out.println("Book issued");
        availability=false;
    }

    public static void main(String[] args) {
        Book2 ob =new Book2("The Titans","Thomas",76.4f,true);
        ob.borrowBook();
        ob.borrowBook();

    }
}
