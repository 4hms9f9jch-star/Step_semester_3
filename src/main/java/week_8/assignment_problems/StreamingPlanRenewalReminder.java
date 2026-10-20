import java.time.LocalDate;
import java.util.Scanner;

abstract class StreamingPlan {
    protected String name;
    protected LocalDate startDate;

    public StreamingPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    public int getValidityDays() {
        return 365;
    }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            StreamingPlan plan;

            switch (type.toUpperCase()) {
                case "BASIC":
                    plan = new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    plan = new StandardPlan(name, startDate);
                    break;
                default:
                    plan = new PremiumPlan(name, startDate);
                    break;
            }

            System.out.println(
                plan.getName() + ": " + plan.calculateRenewalDate()
            );
        }

        sc.close();
    }
}
