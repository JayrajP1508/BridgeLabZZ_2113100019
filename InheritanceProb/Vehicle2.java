public class Main {
    public static void main(String[] args) {
        System.out.println("--- Electric Vehicle ---");
        ElectricVehicle abc = new ElectricVehicle("ABC", 280, 75);
        abc.displayDetails();
        abc.charge();

        System.out.println("\n--- Petrol Vehicle ---");
        PetrolVehicle pqr = new PetrolVehicle("PQR", 250, 60);
        pqr.displayDetails();
        pqr.refuel();
    }
}

interface Refuelable {
    void refuel();
}

class Vehicle2 {
    protected String model;
    protected int maxSpeed;

    public Vehicle2(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle2 {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Vehicle Type: Electric");
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle2 implements Refuelable {
    private int fuelCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel capacity: " + fuelCapacity + " liters.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Vehicle Type: Petrol");
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}


