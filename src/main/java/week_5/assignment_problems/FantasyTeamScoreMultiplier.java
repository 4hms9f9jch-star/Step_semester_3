
import java.util.Arrays;
import java.util.Scanner;

public class FantasyTeamScoreMultiplier {

    static void applyMultipliers(double[] playerScores,
                                 int captainIndex,
                                 int viceCaptainIndex) {

        playerScores[captainIndex] =
                playerScores[captainIndex] * 2;

        playerScores[viceCaptainIndex] =
                playerScores[viceCaptainIndex] * 1.5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        int captainIndex = sc.nextInt();
        int viceCaptainIndex = sc.nextInt();

        applyMultipliers(scores, captainIndex, viceCaptainIndex);

        System.out.println(Arrays.toString(scores));

        sc.close();
    }
}
