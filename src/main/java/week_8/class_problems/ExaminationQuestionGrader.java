import java.util.Scanner;

abstract class ExamQuestion {
    protected String question;
    protected String answer;
    protected int marks;

    public ExamQuestion(String question, String answer, int marks) {
        this.question = question;
        this.answer = answer;
        this.marks = marks;
    }

    public abstract int grade(String studentAnswer);
}

class MultipleChoiceQuestion extends ExamQuestion {
    public MultipleChoiceQuestion(String question, String answer, int marks) {
        super(question, answer, marks);
    }

    public int grade(String studentAnswer) {
        return answer.equalsIgnoreCase(studentAnswer) ? marks : 0;
    }
}

class ShortAnswerQuestion extends ExamQuestion {
    public ShortAnswerQuestion(String question, String answer, int marks) {
        super(question, answer, marks);
    }

    public int grade(String studentAnswer) {
        return answer.trim().equalsIgnoreCase(studentAnswer.trim()) ? marks : 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.nextLine();
            String question = sc.nextLine();
            String answer = sc.nextLine();
            int marks = Integer.parseInt(sc.nextLine());
            String studentAnswer = sc.nextLine();

            ExamQuestion q;

            if (type.equalsIgnoreCase("MCQ")) {
                q = new MultipleChoiceQuestion(question, answer, marks);
            } else {
                q = new ShortAnswerQuestion(question, answer, marks);
            }

            int score = q.grade(studentAnswer);
            System.out.println("Question " + (i + 1) + ": " + score);
            total += score;
        }

        System.out.println("Total: " + total);
        sc.close();
    }
}
