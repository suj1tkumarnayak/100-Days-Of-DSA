package day_043_date_2026_05_12.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLISDP(nums));
    }
    public static int lengthOfLISBinary(int[] nums){
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(list.isEmpty() || list.getLast()<nums[i]){
                list.add(nums[i]);
            }else{
                insertInCorrectPlace(list, nums[i]);
            }
        }

        return list.size();
    }
    public static void insertInCorrectPlace(List<Integer> list, int target){
        int l = 0, h = list.size()-1;
        while (l<=h){
            int m = l+(h-l)/2;
            int num = list.get(m);
            if(target==num){
                return;
            }
            else if (target>num){
                l = m+1;
            }else{
                h = m-1;
            }
        }
        list.add(l, target);
    }
    public static int lengthOfLISDP(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int maxLength = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
    public static int lengthOfLISMemoization(int[] nums){
        int[][] dp = new int[nums.length][nums.length];
        for (int[] row : dp) {
            Arrays.fill(row, -2);
        }
        return lengthOfLISMemoizationHelper(nums, 0, -1, dp);
    }
    public static int lengthOfLISMemoizationHelper(int[] nums, int index, int prevIndex, int[][] dp){
        if(index == nums.length) return 0;
        if(dp[index][prevIndex]!=-2) return dp[index][prevIndex];
        int skip = lengthOfLISRecursionHelper(nums, index+1, prevIndex);
        int taken = 0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            taken = 1+lengthOfLISRecursionHelper(nums, index+1, index);
        }
        return dp[index][prevIndex]=Math.max(skip, taken);
    }
    public static int lengthOfLISRecursion(int[] nums){
        return lengthOfLISRecursionHelper(nums, 0, -1);
    }
    public static int lengthOfLISRecursionHelper(int[] nums, int index, int prevIndex){
        if(index == nums.length) return 0;
        int skip = lengthOfLISRecursionHelper(nums, index+1, prevIndex);
        int taken = 0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            taken = 1+lengthOfLISRecursionHelper(nums, index+1, index);
        }
        return Math.max(skip, taken);
    }
}
