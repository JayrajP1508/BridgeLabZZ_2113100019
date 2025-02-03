package Assignment9.Level1;

public class Vehicle {
    String ownerName;
    char vehicleType;
    static  float registrationFee;


    Vehicle(String ownerName,char vehicleType){
        this.ownerName=ownerName;
        this.vehicleType=vehicleType;
    }

    void displayVehicleDetails(){
        System.out.println("Owner Name: "+ ownerName);
        System.out.println("Vehicle Type :"+ vehicleType);
        System.out.println("Registration Fee : "+registrationFee);
        System.out.println();
    }
    static void updateRegistrationFee(float registrationFee){
        Vehicle.registrationFee=registrationFee;
    }

    public static void main(String[] args) {

        registrationFee=5000f;
        Vehicle v1 = new Vehicle("Amit", 'C');
        Vehicle v2 = new Vehicle("Priya", 'B');
        Vehicle v3 = new Vehicle("Rahul", 'T');
        Vehicle v4 = new Vehicle("Sneha", 'S');
        Vehicle v5 = new Vehicle("Vikram", 'C');

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        updateRegistrationFee(4000f);

        v5.displayVehicleDetails();
    }
}
