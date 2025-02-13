package Assignment15;

public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int start = 0, fuelBalance = 0, totalDeficit = 0;

        for (int i = 0; i < petrol.length; i++) {
            fuelBalance += petrol[i] - distance[i];

            if (fuelBalance < 0) {
                totalDeficit += fuelBalance;
                start = i + 1;
                fuelBalance = 0;
            }
        }

        return (fuelBalance + totalDeficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println("Starting Pump: " + findStartingPoint(petrol, distance));
    }
}
