
import java.util.Scanner;

public class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlacementRecord[] records = new PlacementRecord[3];

        for (int i = 0; i < 3; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            String name = parts[0].trim();
            String company = parts[1].trim();
            double packageLpa = Double.parseDouble(parts[2].trim());

            records[i] = new PlacementRecord(name, company, packageLpa);
        }

        for (PlacementRecord record : records) {
            record.printRecord();
        }

        sc.close();
    }
}

