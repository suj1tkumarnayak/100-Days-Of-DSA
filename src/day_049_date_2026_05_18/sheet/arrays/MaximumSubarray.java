package day_049_date_2026_05_18.sheet.arrays;

import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println();
        maxSubArrayPrint(nums);
    }
    public static void maxSubArrayPrint(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }

        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        int start = 0;
        int end = 0;
        int s = 0; // Tracks the potential starting index of a new subarray

        for (int i = 1; i < arr.length; i++) {
            // Decides whether to extend the current subarray or start a new one
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
                s = i; // Reset the potential starting index
            } else {
                maxEndingHere += arr[i];
            }

            // Update global maximum and final boundaries
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSoFar);
        System.out.println("Start Index: " + start + ", End Index: " + end);
        System.out.println(Arrays.toString(Arrays.copyOf(arr, end-start+1)));
    }
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}
