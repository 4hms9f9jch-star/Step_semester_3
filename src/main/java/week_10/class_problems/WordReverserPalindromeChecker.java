
import java.util.Scanner;

public class WordReverserPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        String reversed = new StringBuilder(word).reverse().toString();

        System.out.println("Reversed: " + reversed);

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }

        sc.close();
    }
}

