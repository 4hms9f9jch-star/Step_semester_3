import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalFines = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new BookItem(title, daysLate);
                    break;

                case "DVD":
                    item = new DVDItem(title, daysLate);
                    break;

                case "MAGAZINE":
                    item = new MagazineItem(title, daysLate);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid item type");
            }

            double fine = item.calculateFine();

            System.out.printf("%s: %.2f%n", item.title, fine);
            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        sc.close();
    }
}
