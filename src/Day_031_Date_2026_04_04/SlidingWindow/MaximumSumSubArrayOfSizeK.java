package Day_031_Date_2026_04_04.SlidingWindow;
//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        System.out.println(maximumSumOfSizeK(nums, 3));
    }

    private static int maximumSumOfSizeK(int[] nums, int k) {
        int sum = 0, lsum, len = nums.length;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        for (int i = k; i < len; i++) {
            lsum = sum-nums[i-k]+nums[i];
            sum = Math.max(lsum, sum);
        }
        
        return sum;
    }
}
