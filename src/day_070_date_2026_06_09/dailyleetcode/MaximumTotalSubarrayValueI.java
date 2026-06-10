package day_070_date_2026_06_09.dailyleetcode;

//https://leetcode.com/problems/maximum-total-subarray-value-i/description/?envType=daily-question&envId=2026-06-09

public class MaximumTotalSubarrayValueI {

    // Write your code inside this method
    public static long maxTotalValue1(int[] nums, int k) {
        return 1;
    }
    public static long maxTotalValue(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];

        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }


        return 1L*k*(max-min);
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1,3,2};
        int k1 = 2;
        System.out.println("Test 1 Result: " + maxTotalValue(nums1, k1));

        // Test Case 2
        int[] nums2 = {4,2,5,1};
        int k2 = 3;
        System.out.println("Test 2 Result: " + maxTotalValue(nums2, k2));
    }
}
