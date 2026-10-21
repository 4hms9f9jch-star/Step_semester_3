
import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if (year % 400 == 0 ||
            (year % 4 == 0 && year % 100 != 0)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }

        sc.close();
    }
}

