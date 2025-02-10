import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.05;
    }

    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return getRentalRate() * 0.03;
    }

    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }
}

class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

class VehicleRentalSystem {
    public static void calculateRentalAndInsurance(List<Vehicle> vehicles, int days) {
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(days);
            double insuranceCost = 0;
            String insuranceDetails = "";

            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable) vehicle).calculateInsurance();
                insuranceDetails = ((Insurable) vehicle).getInsuranceDetails();
            }

            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Rental Cost: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            if (!insuranceDetails.isEmpty()) {
                System.out.println(insuranceDetails);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C001", 50, "INS12345"));
        vehicles.add(new Bike("B001", 20, "INS67890"));
        vehicles.add(new Truck("T001", 100));

        calculateRentalAndInsurance(vehicles, 5);
    }
}
