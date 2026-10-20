import java.util.Scanner;

abstract class Transport {
    protected int distance;

    public Transport(int distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();

    public abstract String getType();
}

class BusTransport extends Transport {
    public BusTransport(int distance) {
        super(distance);
    }

    public double calculateFare() {
        return 5 + (distance * 2);
    }

    public String getType() {
        return "BUS";
    }
}

class TrainTransport extends Transport {
    public TrainTransport(int distance) {
        super(distance);
    }

    public double calculateFare() {
        return 10 + (distance * 1.5);
    }

    public String getType() {
        return "TRAIN";
    }
}

class MetroTransport extends Transport {
    public MetroTransport(int distance) {
        super(distance);
    }

    public double calculateFare() {
        return 15 + (distance * 2.5);
    }

    public String getType() {
        return "METRO";
    }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int distance = sc.nextInt();

            Transport transport;

            switch (type) {
                case "BUS":
                    transport = new BusTransport(distance);
                    break;
                case "TRAIN":
                    transport = new TrainTransport(distance);
                    break;
                default:
                    transport = new MetroTransport(distance);
                    break;
            }

            double fare = transport.calculateFare();
            System.out.printf("%s: %.2f%n", transport.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
