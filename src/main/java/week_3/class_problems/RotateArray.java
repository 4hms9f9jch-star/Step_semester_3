
import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;

        if (n == 0) {
            return nums;
        }

        k = k % n;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter rotation count:");
        int k = sc.nextInt();

        System.out.println(Arrays.toString(rotateArray(nums, k)));

        sc.close();
    }
}
