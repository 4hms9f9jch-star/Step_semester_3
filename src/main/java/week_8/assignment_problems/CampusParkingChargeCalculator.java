import java.util.Scanner;

abstract class ParkingVehicle {
    protected int hours;

    public ParkingVehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public abstract String getType();
}

class BikeVehicle extends ParkingVehicle {
    public BikeVehicle(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return hours * 10.0;
    }

    public String getType() {
        return "BIKE";
    }
}

class CarVehicle extends ParkingVehicle {
    public CarVehicle(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return 30 + (hours - 1) * 20.0;
    }

    public String getType() {
        return "CAR";
    }
}

class TruckVehicle extends ParkingVehicle {
    public TruckVehicle(int hours) {
        super(hours);
    }

    public double calculateCharge() {
        return Math.max(hours * 50.0, 100.0);
    }

    public String getType() {
        return "TRUCK";
    }
}

public class CampusParkingChargeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int hours = sc.nextInt();

            ParkingVehicle vehicle;

            switch (type) {
                case "BIKE":
                    vehicle = new BikeVehicle(hours);
                    break;
                case "CAR":
                    vehicle = new CarVehicle(hours);
                    break;
                default:
                    vehicle = new TruckVehicle(hours);
                    break;
            }

            double charge = vehicle.calculateCharge();
            System.out.printf("%s: %.2f%n", vehicle.getType(), charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
