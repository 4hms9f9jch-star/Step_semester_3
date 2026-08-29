import java.util.Scanner;

public class MergeSortedArrays {

    static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        int[] result = merge(a, b);

        for (int x : result)
            System.out.print(x + " ");

        sc.close();
    }
}