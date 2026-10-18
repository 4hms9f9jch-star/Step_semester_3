
import java.util.Scanner;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {
        String reference = raw.trim();

        if (reference.length() < 3) {
            return reference.toUpperCase();
        }

        return reference.substring(0, 3).toUpperCase()
                + reference.substring(3);
    }

    static String validateAndFormat(String raw) {
        String reference = normalizeReference(raw);

        if (reference.length() != 14) {
            return "Invalid: reference must contain 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9, 14);

        StringBuilder result = new StringBuilder();
        result.append("[").append(bankCode).append("] ");
        result.append("DATE: ");
        result.append(date.substring(0, 2)).append("/");
        result.append(date.substring(2, 4)).append("/");
        result.append(date.substring(4, 6));
        result.append(" | SEQ: ").append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        System.out.println(validateAndFormat(raw));

        sc.close();
    }
}
