import java.util.Scanner;

abstract class CanteenCustomer {
    protected double amount;

    public CanteenCustomer(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getType();
}

class StudentCustomer extends CanteenCustomer {
    public StudentCustomer(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    public String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends CanteenCustomer {
    public StaffCustomer(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    public String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends CanteenCustomer {
    public GuestCustomer(double amount) {
        super(amount);
    }

    public double calculateFinalAmount() {
        return amount + 10;
    }

    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            CanteenCustomer customer;

            switch (type) {
                case "STUDENT":
                    customer = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    customer = new StaffCustomer(amount);
                    break;
                default:
                    customer = new GuestCustomer(amount);
                    break;
            }

            double finalAmount = customer.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", customer.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
