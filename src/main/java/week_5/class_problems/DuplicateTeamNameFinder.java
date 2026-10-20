
import java.util.Scanner;

public class DuplicateTeamNameFinder {

    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] teamNames = new String[n];

        for (int i = 0; i < n; i++) {
            teamNames[i] = sc.nextLine();
        }

        System.out.println(findDuplicateTeam(teamNames));

        sc.close();
    }
}
