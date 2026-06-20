package day_077_date_2026_06_19.dailyproblem;

import java.util.ArrayList;

public class EqualizeAllPrefixSums {
    public static void main(String[] args) {
        // Test Case 1: Your original input array
        int[] arr1 = {1, 1, 1, 7, 7, 10, 19};
        System.out.println("Test 1: " + optimalArray(arr1));
        // Expected Output: [0, 0, 0, 6, 12, 21, 33]

        // Test Case 2: Array with rapidly growing values
        int[] arr2 = {1, 6, 9, 12};
        System.out.println("Test 2: " + optimalArray(arr2));
        // Expected Output: [0, 5, 8, 14]
    }

    public static ArrayList<Integer> optimalArray(int[] arr) {


        return new ArrayList<>();
    }
}
