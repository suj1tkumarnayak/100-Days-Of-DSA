package day_065_date_2026_06_03.arrays;

import java.util.ArrayList;

public class ArrayLeaders {
    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        System.out.println("Original 1: [16, 17, 4, 3, 5, 2]");
        System.out.println("Leaders 1:  " + leaders(arr1)); // Expected: [17, 5, 2]
        System.out.println();

        // Test Case 2: Strictly increasing
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Original 2: [1, 2, 3, 4, 5]");
        System.out.println("Leaders 2:  " + leaders(arr2)); // Expected: [5]
        System.out.println();

        // Test Case 3: Strictly decreasing
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("Original 3: [5, 4, 3, 2, 1]");
        System.out.println("Leaders 3:  " + leaders(arr3)); // Expected: [5, 4, 3, 2, 1]
        System.out.println();
    }

    /**
     * Finds all leaders in the array.
     * An element is a leader if it is greater than or equal to all elements to its right.
     * @param arr The input array.
     * @return An ArrayList containing the leaders in the order they appear.
     */
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        int n = arr.length, currLeader = arr[n-1];
        result.add(currLeader);

        for (int i = n-2; i >= 0; i--) {
            if(arr[i]>currLeader){
                result.add(arr[i]);
                currLeader = arr[i];
            }
        }

        reverse(result);
        return result;
    }
    static void reverse(ArrayList<Integer> list){
        int i = 0, j = list.size()-1;
        while (i<j){
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
}
