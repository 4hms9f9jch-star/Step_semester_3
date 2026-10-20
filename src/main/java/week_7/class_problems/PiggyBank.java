
public class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        savings = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit");
            return;
        }
        savings += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        System.out.println("Initial savings: " + pb.getSavings());

        pb.deposit(100);
        System.out.println("After deposit: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("After withdrawal: " + pb.getSavings());

        pb.withdraw(500);
        System.out.println("Final savings: " + pb.getSavings());
    }
}
