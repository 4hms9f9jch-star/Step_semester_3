
import java.util.Scanner;

public class FactorialCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        long factorial = 1;

        if (number < 0) {
            System.out.println("Factorial is not defined");
        } else {
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }

            System.out.println("Factorial: " + factorial);
        }

        sc.close();
    }
}
