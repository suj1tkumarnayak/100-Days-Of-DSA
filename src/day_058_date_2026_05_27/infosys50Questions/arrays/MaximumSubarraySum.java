package day_058_date_2026_05_27.infosys50Questions.arrays;

public class MaximumSubarraySum {

    public static int[] maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1, 0}; // Return empty tracking if array is empty
        }

        int currSum = nums[0];
        int maxSum = nums[0];

        // Track the final best window indices
        int start = 0;
        int end = 0;

        // Tracks where the current local subarray started
        int currentStart = 0;

        for (int k = 1; k < nums.length; k++) {
            int num = nums[k];

            // If current element is greater than continuing the previous subarray,
            // start a brand new subarray at index k
            if (num > currSum + num) {
                currSum = num;
                currentStart = k;
            } else {
                // Otherwise, extend the existing subarray
                currSum = currSum + num;
            }

            // If we found a strictly better maximum sum, lock in the indices
            if (currSum > maxSum) {
                maxSum = currSum;
                start = currentStart;
                end = k;
            }
        }

        // Returning start index, end index, and the maximum sum for utility
        return new int[]{start, end, maxSum};
    }

    public static void main(String[] args) {
        // Test case: The maximum subarray is [4, -1, 2, 1] with sum = 6
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result[2]);
        System.out.println("Start Index: " + result[0]);
        System.out.println("End Index: " + result[1]);

        System.out.print("Actual Subarray Elements: ");
        for (int i = result[0]; i <= result[1]; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
