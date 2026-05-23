package day_054_date_2026_05_23.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(robDP(nums));
    }

    public static int robDP(int[] nums){
        int n = nums.length;
        if(n==1) return nums[0];

        return Math.max(robDPHelper(nums, 0, n-2), robDPHelper(nums, 1, n-1));
    }
    public static int robDPHelper(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];

        int length = end - start + 1;
        int[] dp = new int[length];

        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < length; i++) {
            // map current dp index back to the actual nums index
            int currentHouseValue = nums[start + i];
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + currentHouseValue);
        }
        return dp[length - 1];
    }


    public static int robRecursion(int[] nums){
        int[][] dp = new int[nums.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return Math.max(dfs(nums, 0, 1, dp), dfs(nums, 1, 0, dp));
    }
    public static int dfs(int[] nums, int index, int flag, int[][] dp){
        if(index>=nums.length || (flag==1 && index == nums.length-1)){
            return 0;
        }

        if(dp[index][flag]!=-1) return dp[index][flag];

        int take = nums[index] + dfs(nums, index+2, flag, dp);
        int skip = dfs(nums, index+1, flag, dp);

        return dp[index][flag] = Math.max(take, skip);
    }
}
