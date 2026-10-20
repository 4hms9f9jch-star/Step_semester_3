
public class Scorecard {
    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int totalQuestions) {
        results = new boolean[totalQuestions];
        answersRecorded = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answersRecorded >= results.length) {
            System.out.println("All questions have been recorded");
            return;
        }

        results[answersRecorded] = correct;
        answersRecorded++;
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Total score: " + sc.getScore());
    }
}
