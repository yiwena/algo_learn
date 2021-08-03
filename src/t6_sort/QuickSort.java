package t6_sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 5, 1, 23, 11};
        quickSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int length) {
        quickSort(arr, 0, length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int partition = partition(arr, start, end);
        quickSort(arr, start, partition - 1);
        quickSort(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i++] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;
        System.out.println("i = " + i);
        return i;
    }
}
