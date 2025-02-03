class Vehicle {
    private static double registrationFee = 500.0;
    private final int registrationNumber;
    private String ownerName;
    private String vehicleType;
    private static int idCounter = 1;

    public Vehicle(String ownerName, String vehicleType) {
        this.registrationNumber = idCounter++;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John Doe", "Car");
        Vehicle v2 = new Vehicle("Jane Smith", "Bike");

        v1.displayRegistrationDetails();
        System.out.println();
        v2.displayRegistrationDetails();
        System.out.println();
        Vehicle.updateRegistrationFee(600);
        v1.displayRegistrationDetails();
    }
}
