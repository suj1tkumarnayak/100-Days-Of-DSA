package day_072_date_2026_06_13.infosys_50_questions.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Result 1: " + subarraySum(nums1, k1)); // Expected: 2

        // Example 2
        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Result 2: " + subarraySum(nums2, k2)); // Expected: 2

        // New Test Case 3 (With negative numbers)
        int[] nums3 = {10, 2, -2, -20, 10};
        int k3 = -10;
        System.out.println("Result 3: " + subarraySum(nums3, k3)); // Expected: 3

        // New Test Case 4
        int[] nums4 = {1, 4, 20, 3, 10, 5};
        int k4 = 33;
        System.out.println("Result 4: " + subarraySum(nums4, k4)); // Expected: 1
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        int count = 0;
        prefixSumCount.put(0, 1);

        int sum = 0;

        for (int num : nums) {
            sum += num;

            if(prefixSumCount.containsKey(sum-k)){
                count += prefixSumCount.get(sum-k);
            }

            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    static int bruteforce(int arr[], int tar){
        int count = 0;
        int n = arr.length;

        // outer loop is for the start element
        for (int i = 0; i < n; i++) {
            // inner loop for the end element
            for (int j = i; j < n; j++) {
                int sum = 0;
                // to do the sum
                for (int k = i; k <= j; k++) {
                    sum+= arr[k];
                }
                if(sum==tar) count++;
            }
        }

        return count;
    }

    static int betterBruteforce(int arr[], int tar){
        int count = 0;
        int n = arr.length;

        // outer loop is for the start element
        for (int i = 0; i < n; i++) {
            // inner loop for the end element
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                // to do the sum
                if(sum==tar) count++;
            }
        }

        return count;
    }
}
