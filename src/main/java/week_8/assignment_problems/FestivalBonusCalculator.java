import java.util.Scanner;

abstract class FestivalEmployee {
    protected String name;
    protected double salary;

    public FestivalEmployee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends FestivalEmployee {
    public FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends FestivalEmployee {
    public PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class InternEmployee extends FestivalEmployee {
    public InternEmployee(String name, double salary) {
        super(name, salary);
    }

    public double calculateBonus() {
        return 2000.0;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            double salary = sc.nextDouble();

            FestivalEmployee employee;

            switch (type) {
                case "FULLTIME":
                    employee = new FullTimeEmployee(name, salary);
                    break;
                case "PARTTIME":
                    employee = new PartTimeEmployee(name, salary);
                    break;
                default:
                    employee = new InternEmployee(name, salary);
                    break;
            }

            double bonus = employee.calculateBonus();
            System.out.printf("%s: %.2f%n", employee.getName(), bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
