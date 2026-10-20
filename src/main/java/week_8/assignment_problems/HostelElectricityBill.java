import java.util.Scanner;

abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class SingleHostelRoom extends HostelRoom {
    public SingleHostelRoom(int units) {
        super(units);
    }

    public double calculateBill() {
        return units * 8.0;
    }

    public String getType() {
        return "SINGLE";
    }
}

class SharedHostelRoom extends HostelRoom {
    private int occupants;

    public SharedHostelRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    public double calculateBill() {
        return (units * 6.0) / occupants;
    }

    public String getType() {
        return "SHARED";
    }
}

class ACHostelRoom extends HostelRoom {
    public ACHostelRoom(int units) {
        super(units);
    }

    public double calculateBill() {
        return (units * 10.0) + 200;
    }

    public String getType() {
        return "AC";
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            HostelRoom room;

            switch (type) {
                case "SINGLE":
                    room = new SingleHostelRoom(units);
                    break;
                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedHostelRoom(units, occupants);
                    break;
                default:
                    room = new ACHostelRoom(units);
                    break;
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", room.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
