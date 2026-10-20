
import java.util.Scanner;

public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0.0;
        }

        int sum = 0;

        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);

            if (i > 0) {
                result.append(" | ");
            }

            result.append("Match ").append(i).append(": ");

            if (average >= threshold) {
                result.append("Power Surge");
            } else {
                result.append("Normal");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matches = sc.nextInt();
        int[][] runsPerOver = new int[matches][];

        for (int i = 0; i < matches; i++) {
            int overs = sc.nextInt();
            runsPerOver[i] = new int[overs];

            for (int j = 0; j < overs; j++) {
                runsPerOver[i][j] = sc.nextInt();
            }
        }

        int threshold = sc.nextInt();

        System.out.println(classifyMatches(runsPerOver, threshold));

        sc.close();
    }
}
