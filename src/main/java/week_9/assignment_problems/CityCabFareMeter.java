
import java.util.Scanner;

abstract class Cab {
    protected double km;
    protected static final double MIN_FARE = 100.0;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRate();

    public boolean supportsNightService() {
        return false;
    }

    public double calculateFare(boolean night) {
        double fare = Math.max(km * getRate(), MIN_FARE);

        if (night && supportsNightService()) {
            fare *= 1.20;
        }

        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) {
        super(km);
    }

    public double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab {
    public SedanCab(double km) {
        super(km);
    }

    public double getRate() {
        return 14.0;
    }

    public boolean supportsNightService() {
        return true;
    }
}

class SUVCab extends Cab {
    public SUVCab(double km) {
        super(km);
    }

    public double getRate() {
        return 18.0;
    }

    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }

            boolean night = time.equals("NIGHT");

            if (night && !cab.supportsNightService()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare = cab.calculateFare(night);
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
