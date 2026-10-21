
import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int rotations = k % n;

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + rotations) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int k = 7;

        String[] result = rotateRoster(names, k);

        System.out.println(Arrays.toString(result));
    }
}
