
import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        if (review.trim().isEmpty()) {
            System.out.println("Short Words: 0");
            System.out.println("Medium Words: 0");
            System.out.println("Long Words: 0");
            return;
        }

        for (String word : words) {
            int length = word.replaceAll("[^a-zA-Z]", "").length();

            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else if (length >= 9) {
                longWords++;
            }
        }

        System.out.println("Short Words: " + shortWords);
        System.out.println("Medium Words: " + mediumWords);
        System.out.println("Long Words: " + longWords);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        classifyWordLengths(review);

        sc.close();
    }
}
