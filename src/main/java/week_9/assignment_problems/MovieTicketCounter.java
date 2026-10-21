
import java.util.Scanner;

abstract class MovieTicket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public MovieTicket(int count) {
        this.count = count;
    }

    public abstract double getPrice();

    public double calculateAmount() {
        return count * (getPrice() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 150.0;
    }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super(count);
    }

    public double getPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            MovieTicket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularTicket(count);
                    break;
                case "PREMIUM":
                    ticket = new PremiumTicket(count);
                    break;
                case "RECLINER":
                    ticket = new ReclinerTicket(count);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid seat type");
            }

            double amount = ticket.calculateAmount();
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

