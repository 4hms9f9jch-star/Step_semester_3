import java.util.Scanner;

abstract class Staff {
    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    staff = new FullTimeStaff(name, sc.nextDouble());
                    break;

                case "HOURLY":
                    staff = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
                    break;

                case "INTERN":
                    staff = new InternStaff(name, sc.nextDouble());
                    break;

                default:
                    throw new IllegalArgumentException("Invalid staff type");
            }

            double pay = staff.calculatePay();

            System.out.printf("%s: %.2f%n", staff.name, pay);
            totalPayroll += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);

        sc.close();
    }
}
