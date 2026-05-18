package day_049_date_2026_05_18.sheet.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }

    public static int lengthOfLISRecursion(int[] nums){
        int[][] dp = new int[nums.length][nums.length];

        for (int row[] : dp) {
            Arrays.fill(row, -2);
        }

        return helper(nums, 0, -1, dp);
    }

    public static int helper(int[] nums, int indx, int prevIndex, int[][] dp){
        if(indx == nums.length){
            return 0;
        }

        if(dp[indx][prevIndex+1]!=-2) return dp[indx][prevIndex+1];
        //skip
        int skip = helper(nums, indx+1, prevIndex, dp);
        //take
        int take = 0;
        if(prevIndex==-1 || nums[prevIndex]<nums[indx]){
            take = 1 + helper(nums, indx+1, indx, dp);
        }

        return dp[indx][prevIndex+1]=Math.max(skip, take);
    }

    public static int lengthOfLISBinarySearch(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if(list.isEmpty() || num>list.getLast()){
                list.add(num);
            }else{
                int ind = binarySearch(list, num);
                list.set(ind, num);
            }
        }


        return list.size();
    }
    private static int binarySearch(List<Integer> nums, int target){
        int l = 0, h = nums.size()-1;
        while (l<=h){
            int m = l+(h-l)/2;
            if(nums.get(m)==target){
                return m;
            }else if(nums.get(m)>target){
                h = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}
