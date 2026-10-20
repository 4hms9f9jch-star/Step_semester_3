
import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    static String normalizeCode(String raw) {
        String code = raw.trim();

        if (code.length() < 3) {
            return code.toUpperCase();
        }

        return code.substring(0, 3).toUpperCase()
                + code.substring(3);
    }

    static String validateAndFormat(String raw) {
        String code = normalizeCode(raw);

        if (code.length() != 13) {
            return "Invalid: code must contain 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder result = new StringBuilder();
        result.append("[").append(publisher).append("] ");
        result.append("YEAR: ").append(year);
        result.append(" | CATALOG: ").append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String code = sc.nextLine();

        System.out.println(validateAndFormat(code));

        sc.close();
    }
}
