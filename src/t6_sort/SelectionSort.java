package t6_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int value = a[i];
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (value > a[j]) {
                    index = j;
                    value = a[j];
                }
            }
            if (index != i) {
                int temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 5, 1, 23, 11};
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
