package day_065_date_2026_06_03.arrays;

import java.util.Arrays;

public class LeftRotateAnArrayByDPlaces {

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int d1 = 3;
        System.out.println("Original 1: " + Arrays.toString(arr1));
        leftRotate(arr1, d1);
        System.out.println("Rotated d=3: " + Arrays.toString(arr1)); // Expected: [4, 5, 6, 7, 1, 2, 3]
        System.out.println();

        // Test Case 2 (d is greater than array length)
        int[] arr2 = {10, 20, 30, 40};
        int d2 = 6;
        System.out.println("Original 2: " + Arrays.toString(arr2));
        leftRotate(arr2, d2);
        System.out.println("Rotated d=6: " + Arrays.toString(arr2)); // Expected: [30, 40, 10, 20]
        System.out.println();

        // Test Case
        int[] arr3 = {1, 2, 3, 4, 5};
        int d3 = 2;
        System.out.println("Original 2: " + Arrays.toString(arr3));
        leftRotate(arr3, d3);
        System.out.println("Rotated d=6: " + Arrays.toString(arr3)); // Expected: [30, 40, 10, 20]
        System.out.println();
    }

    public static void leftRotate1(int[] arr, int d) {
        int n = arr.length;
        d = d%n;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = arr[(i+d)%n];
        }
        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }

    public static void leftRotate(int[] arr, int d) {
        int n = arr.length;
        d = d%n;
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }
    public static void reverse(int[] arr, int i, int j){
        while (i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
