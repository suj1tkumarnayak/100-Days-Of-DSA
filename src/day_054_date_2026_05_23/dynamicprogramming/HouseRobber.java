package day_054_date_2026_05_23.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(robDP2(nums));
    }

    private static int robDP2(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int num : nums) {
            int temp = Math.max(rob2,  num+rob1);
            rob1 = rob2;
            rob2 = temp;
        }


        return rob2;
    }

    public static int robRecursion(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
    public static int helper(int[] nums, int index, int[] dp){
        if(index>=nums.length){
            return 0;
        }
        if(dp[index] != -1) return dp[index];
        // rob the house
        int take = nums[index] + helper(nums, index+2, dp);
        // skip the house
        int skip = helper(nums, index+1, dp);

        return dp[index] = Math.max(take, skip);
    }
    public static int robDP(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
