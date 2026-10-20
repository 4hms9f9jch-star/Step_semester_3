
import java.util.Scanner;

public class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] playerNames = new String[n];

        for (int i = 0; i < n; i++) {
            playerNames[i] = sc.nextLine();
        }

        System.out.println(findDuplicatePick(playerNames));

        sc.close();
    }
}
