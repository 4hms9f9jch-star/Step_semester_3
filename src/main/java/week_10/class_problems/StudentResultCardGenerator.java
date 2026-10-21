
import java.util.Scanner;

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();

            double average = (m1 + m2 + m3) / 3.0;
            char grade;

            if (average >= 90) {
                grade = 'A';
            } else if (average >= 75) {
                grade = 'B';
            } else if (average >= 60) {
                grade = 'C';
            } else if (average >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Name: " + name.toUpperCase());
            System.out.printf("Average: %.1f%n", average);
            System.out.println("Grade: " + grade);
        }

        sc.close();
    }
}

