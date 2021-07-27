package t6_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > value) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 5, 1, 23, 11};
        insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
