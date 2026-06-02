package day_065_date_2026_06_03.arrays;

import java.util.Arrays;

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        // Test Case 1: Mixed zeros and non-zeros
        int[] arr1 = {1, 0, 2, 3, 0, 4, 0, 5};
        System.out.println("Original 1: " + Arrays.toString(arr1));
        moveZeroes(arr1);
        System.out.println("Modified 1: " + Arrays.toString(arr1)); // Expected: [1, 2, 3, 4, 5, 0, 0, 0]
        System.out.println();

        // Test Case 2: No zeros
        int[] arr2 = {1, 2, 3};
        System.out.println("Original 2: " + Arrays.toString(arr2));
        moveZeroes(arr2);
        System.out.println("Modified 2: " + Arrays.toString(arr2)); // Expected: [1, 2, 3]
        System.out.println();

        // Test Case 3: All zeros
        int[] arr3 = {0, 0, 0};
        System.out.println("Original 3: " + Arrays.toString(arr3));
        moveZeroes(arr3);
        System.out.println("Modified 3: " + Arrays.toString(arr3)); // Expected: [0, 0, 0]
        System.out.println();
    }
    public static void moveZeroes(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int zeroIndx = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                arr[zeroIndx++] = arr[i];
            }
        }
        for (int i = zeroIndx; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
    public static void moveZeroes1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int i = 0, j = 0, n = arr.length;
        while (i < n && j < n) {
            while (i < n && arr[i] != 0) {
                i++;
            }
            j = i + 1;
            while (j < n && arr[j] == 0) {
                j++;
            }
            if (i < n && j < n) {
                swap(arr, i, j);
            }
            //i = j;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
