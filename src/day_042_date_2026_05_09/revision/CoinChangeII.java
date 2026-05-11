package day_042_date_2026_05_09.revision;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(coinChangeIIBottomUp(amount, coins));
    }
    public static int coinChangeIIBottomUp(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount+1; i++) {
                dp[i] = dp[i]+dp[i-coin];
            }
        }

        return dp[amount];
    }
    public static int coinChangeIIMemoization(int amount,int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ways = coinChangeIIMemoizationHelper(amount,coins, 0, dp);
        return ways;
    }
    public static int coinChangeIIMemoizationHelper(int amount, int[] coins, int index, int[][] dp){
        if(amount==0) return 1;
        if(amount<0 || index==coins.length) return 0;

        if(dp[index][amount]!=-1) return dp[index][amount];

        int taken = coinChangeIIMemoizationHelper(amount-coins[index],coins,  index, dp);
        int skip = coinChangeIIMemoizationHelper(amount, coins, index+1, dp);

        return dp[index][amount]=taken+skip;
    }
    public static int coinChangeIIRecursion( int amount,int[] coins) {
        int ways = coinChangeIIRecursionHelper(amount,coins, 0);
        return ways;
    }
    public static int coinChangeIIRecursionHelper(int amount, int[] coins, int index){
        if(amount==0) return 1;
        if(amount<0 || index==coins.length) return 0;

        int taken = coinChangeIIRecursionHelper(amount-coins[index],coins,  index);
        int skip = coinChangeIIRecursionHelper(amount, coins, index+1);

        return taken+skip;
    }
}
