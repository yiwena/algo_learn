package t6_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j=0;j<n-i-1;j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 5, 1, 23, 11};
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
