
import java.util.Scanner;

public class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println(title + " by " + author + " - "
                + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookInventory[] books = new BookInventory[4];

        for (int i = 0; i < 4; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            String title = parts[0].trim();
            String author = parts[1].trim();
            int copies = Integer.parseInt(parts[2].trim());

            books[i] = new BookInventory(title, author, copies);
        }

        for (BookInventory book : books) {
            book.printEntry();
        }

        sc.close();
    }
}
