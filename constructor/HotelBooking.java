package Assignment9.Level1;

public class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    HotelBooking() {
        guestName = "";
        roomType = "";
        nights = 0;
    }

    HotelBooking(String guestName,String roomType,int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;

        System.out.println("Paramatrized constructor called!!");
    }

    HotelBooking(HotelBooking ob) {
        this.guestName = ob.guestName;
        this.roomType = ob.roomType;
        this.nights = ob.nights;

        System.out.println("Copy constructor called!!");
    }

    public static void main(String[] args) {

        HotelBooking ob = new HotelBooking("Harsh", "Deluxe", 5);

        HotelBooking ob1 = new HotelBooking(ob);


    }
}
