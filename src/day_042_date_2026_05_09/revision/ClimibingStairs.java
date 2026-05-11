package day_042_date_2026_05_09.revision;

import java.util.Arrays;

public class ClimibingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairsBottomUp(n));
    }
    public static int climbStairsBottomUp(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
    public static int climbStairsMemoization(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsMemoizationHelper(n, dp);
    }
    public static int climbStairsMemoizationHelper(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ones = climbStairsRecursion(n-1);
        int twos = climbStairsRecursion(n-2);
        return dp[n]=ones+twos;
    }
    public static int climbStairsRecursion(int n) {
        if(n==0) return 1;
        if(n<0) return 0;
        int ones = climbStairsRecursion(n-1);
        int twos = climbStairsRecursion(n-2);
        return ones+twos;
    }
}
