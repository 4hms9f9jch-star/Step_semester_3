import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate = LocalDate.of(2023, 10, 26);

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();

    public LocalDate getDueDate() {
        return currentDate.plusDays(getBorrowingDays());
    }

    public String getTitle() {
        return title;
    }

    public abstract String getType();
}

class Book extends LibraryItem {
    public Book(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 14;
    }

    public String getType() {
        return "BOOK";
    }
}

class DVD extends LibraryItem {
    public DVD(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 7;
    }

    public String getType() {
        return "DVD";
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title) {
        super(title);
    }

    public int getBorrowingDays() {
        return 3;
    }

    public String getType() {
        return "MAGAZINE";
    }
}

public class LibraryDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                default:
                    item = new Magazine(title);
                    break;
            }

            System.out.println(item.getTitle() + ": " + item.getDueDate());
        }

        sc.close();
    }
}
