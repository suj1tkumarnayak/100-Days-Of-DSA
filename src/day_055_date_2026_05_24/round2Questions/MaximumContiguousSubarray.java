package day_055_date_2026_05_24.round2Questions;

public class MaximumContiguousSubarray {

    public static void main(String[] args) {
        // Mock Array (Standard Kadane's algorithm test case)
        // Expected max subarray sum is 6, from subarray: [4, -1, 2, 1]
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        MaximumContiguousSubarray solution = new MaximumContiguousSubarray();
        int maxSum = solution.maxSubArray(nums);

        System.out.println("Maximum Contiguous Subarray Sum: " + maxSum);
    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int currMax = nums[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(nums[i], nums[i]+currMax);
            max = Math.max(currMax, max);
        }

        return max;
    }
}
