
import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    protected static final double COST_PER_UNIT = 8.0;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPower();

    public boolean supportsSaverMode() {
        return false;
    }

    public double calculateUnits(boolean saver) {
        double units = getPower() * hours / 1000.0;

        if (saver && supportsSaverMode()) {
            units *= 0.75;
        }

        return units;
    }

    public double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    public double getPower() {
        return 150.0;
    }
}

class AirConditioner extends Appliance {
    public AirConditioner(double hours) {
        super(hours);
    }

    public double getPower() {
        return 1500.0;
    }

    public boolean supportsSaverMode() {
        return true;
    }
}

class Television extends Appliance {
    public Television(double hours) {
        super(hours);
    }

    public double getPower() {
        return 100.0;
    }
}

class WashingMachine extends Appliance {
    public WashingMachine(double hours) {
        super(hours);
    }

    public double getPower() {
        return 500.0;
    }

    public boolean supportsSaverMode() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;
            if (sc.hasNext("(?i)SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AirConditioner(hours);
                    break;
                case "TV":
                    appliance = new Television(hours);
                    break;
                case "WASHER":
                    appliance = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid appliance type");
            }

            if (saver && !appliance.supportsSaverMode()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits(saver);
            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n", type, units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
