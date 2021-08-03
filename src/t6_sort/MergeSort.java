package t6_sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 5, 1, 23, 11};
        mergeSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int length) {
        mergeSort(arr, 0, length-1);
    }
    public static void mergeSort(int[] arr, int start,int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] newArr = new int[end - start+1];
        int p = start;
        int q = mid+1;
        int tmp = 0;
        while (p <= mid && q <= end) {
            if (arr[p] > arr[q]) {
                newArr[tmp] = arr[q];
                q++;
            }else{
                newArr[tmp] = arr[p];
                p++;
            }
            tmp++;
        }
        while (p <= mid) {
            newArr[tmp] = arr[p];
            p++;
            tmp++;
        }
        while (q <= end) {
            newArr[tmp] = arr[q];
            q++;
            tmp++;
        }
        tmp = 0;
        for (int i = start; i <= end; i++) {
            arr[i] = newArr[tmp];
            tmp++;
        }
    }
}
