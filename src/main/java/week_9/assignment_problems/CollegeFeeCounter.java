
import java.util.Scanner;

abstract class CollegeStudent {
    protected String name;
    protected static final double TUITION_FEE = 40000.0;
    protected static final double TRANSPORT_FEE = 12000.0;

    public CollegeStudent(String name) {
        this.name = name;
    }

    public abstract double calculateFee();

    public boolean usesBus() {
        return false;
    }

    public double getTotalFee() {
        return calculateFee() + (usesBus() ? TRANSPORT_FEE : 0);
    }
}

class DayScholar extends CollegeStudent {
    public DayScholar(String name) {
        super(name);
    }

    public double calculateFee() {
        return TUITION_FEE;
    }

    public boolean usesBus() {
        return true;
    }
}

class Hosteller extends CollegeStudent {
    public Hosteller(String name) {
        super(name);
    }

    public double calculateFee() {
        return TUITION_FEE + 60000.0;
    }
}

class ScholarshipStudent extends CollegeStudent {
    public ScholarshipStudent(String name) {
        super(name);
    }

    public double calculateFee() {
        return TUITION_FEE / 2;
    }

    public boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            CollegeStudent student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid student type");
            }

            double fee = student.getTotalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
