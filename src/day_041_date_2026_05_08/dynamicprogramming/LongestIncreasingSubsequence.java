package day_041_date_2026_05_08.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums, 0, -1));
    }
    public static int lengthOfLIS(int[] nums, int index, int prevIndex){
        if(index== nums.length) return 0;

        //skip
        int notTaken = lengthOfLIS(nums, index+1, prevIndex);

        //taken
        int taken = 0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            taken = 1+lengthOfLIS(nums, index+1, index);
        }

        return Math.max(taken, notTaken);
    }
    public static int lengthOfLIS(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length, maxLength = 1;
        int[] dp = new int[n];

        // Initialize dp array with 1 as the minimum length of any subsequence is 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Iterate over each element in the array
        for (int i = 1; i < n; i++) {
            // Check all previous elements to find the longest increasing subsequence
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // Update the maximum length
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
