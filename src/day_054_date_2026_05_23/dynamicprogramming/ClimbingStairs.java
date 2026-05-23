package day_054_date_2026_05_23.dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(climbStairsDP2(n));
    }
    public static int climbStairsDP2(int n){
        int stair1 = 1, stair2 = 2;

        for (int i = 3; i <= n; i++) {
            int stairN = stair1+stair2;
            stair1 = stair2;
            stair2 = stairN;
        }
        return stair2;
    }
    public static int climbStairsDP(int n){
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int climbStairsRecursion(int n, int[] dp){
        if(n==0) return 1;
        if(n<0) return 0;

        if(dp[n]!=-1) return dp[n];
        //take 1 step
        int one = climbStairsRecursion(n-1, dp);
        //take 2 step
        int two = climbStairsRecursion(n-2, dp);

        return dp[n] = one+two;
    }
}
