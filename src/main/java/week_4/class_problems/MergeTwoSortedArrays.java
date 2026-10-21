package main.java.week_4.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArrays {

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of first array:");
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter size of second array:");
        int m = sc.nextInt();
        int[] arr2 = new int[m];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

        sc.close();
    }
}
