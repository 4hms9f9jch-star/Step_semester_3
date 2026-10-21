import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateFare();

    public double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    public double calculateFare() {
        return distanceKm * 2.0;
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    public double calculateFare() {
        return distanceKm * 1.5;
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    public double calculateFare() {
        return 2500 + distanceKm * 4.0;
    }
}

public class TravelBookingCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            TravelBooking booking;

            switch (mode) {
                case "BUS":
                    booking = new BusBooking(distance);
                    break;

                case "TRAIN":
                    booking = new TrainBooking(distance);
                    break;

                case "FLIGHT":
                    booking = new FlightBooking(distance);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid travel mode");
            }

            System.out.printf("%s: %.2f%n",
                    mode, booking.calculateTotal());
        }

        sc.close();
    }
}
