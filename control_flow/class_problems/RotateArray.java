import java.util.Scanner;

public class RotateArray {

    static int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int k = sc.nextInt();

        int[] result = rotate(nums, k);

        for (int x : result)
            System.out.print(x + " ");

        sc.close();
    }
}