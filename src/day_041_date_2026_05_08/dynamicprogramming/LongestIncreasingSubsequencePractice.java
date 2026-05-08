package day_041_date_2026_05_08.dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequencePractice {
    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLISMemoization(nums));
    }
    public static int lengthOfLISMemoization(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = lengthOfLISMemoizationHelper(nums,0, -1, dp);
        return res;
    }
    public static int lengthOfLISMemoizationHelper(int[] nums,int index, int prevIndex, int[][] dp){
        if(index == nums.length) return 0;
        if(dp[index][prevIndex+1]!=-1){
            return dp[index][prevIndex+1];
        }

        int notTaken = lengthOfLISMemoizationHelper(nums, index+1, prevIndex, dp);

        int taken = 0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            taken = 1+lengthOfLISMemoizationHelper(nums, index+1, index, dp);
        }

        return dp[index][prevIndex+1]=Math.max(taken, notTaken);
    }

    public static int lengthOfLISRecursion(int[] nums) {
        int res = lengthOfLISRecursionHelper(nums, 0, -1);
        return res;
    }
    public static int lengthOfLISRecursionHelper(int[] nums, int index, int prev){
        if(index== nums.length){
            return 0;
        }

        //take
        int notTaken = lengthOfLISRecursionHelper(nums, index+1, prev);

        int taken = 0;
        if(prev==-1 || nums[index]>nums[prev]){
            taken = 1+lengthOfLISRecursionHelper(nums, index+1, index);
        }

        return Math.max(taken, notTaken);
    }
}
