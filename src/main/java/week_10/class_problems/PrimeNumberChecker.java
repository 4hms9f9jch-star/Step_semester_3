
import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        boolean prime = number >= 2;

        for (int i = 2; i <= number / i && prime; i++) {
            if (number % i == 0) {
                prime = false;
            }
        }

        if (prime) {
            System.out.println(number + " is prime");
        } else {
            System.out.println(number + " is not prime");
        }

        sc.close();
    }
}
