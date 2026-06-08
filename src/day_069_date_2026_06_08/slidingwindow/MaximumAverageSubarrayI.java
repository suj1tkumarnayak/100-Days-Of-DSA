package day_069_date_2026_06_08.slidingwindow;

// https://leetcode.com/problems/maximum-average-subarray-i/

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        double sum = -Double.MAX_VALUE;
        double currSum = 0.0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if(i>=k-1){
                sum = Math.max(sum, currSum);
                currSum -= nums[i-k+1];
            }
        }

        return sum/k;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI solver = new MaximumAverageSubarrayI();

        // Test Case 1
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println("Test 1 - Expected: 12.75, Actual: " + solver.findMaxAverage(nums1, k1));

        // Test Case 2
        int[] nums2 = {5};
        int k2 = 1;
        System.out.println("Test 2 - Expected: 5.0, Actual: " + solver.findMaxAverage(nums2, k2));

        // Test Case 2
        int[] nums3 = {-1};
        int k3 = 1;
        System.out.println("Test 3 - Expected: -1.0, Actual: " + solver.findMaxAverage(nums3, k3));
    }
}
