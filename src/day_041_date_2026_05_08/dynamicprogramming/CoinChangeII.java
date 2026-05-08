package day_041_date_2026_05_08.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(changeBottomUp(amount, coins));
    }
    public static int changeBottomUp(int amount, int[] coins){
        int n = amount+1;

        int[] dp = new int[n];

        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < n; i++) {
                dp[i] = dp[i] + dp[i-coin];
            }
        }
        
        return dp[amount];
    }
    public static int changeMemoization(int amount, int[] coins){
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return changeMemoizationHelper(amount, coins, 0, dp);
    }
    public static int changeMemoizationHelper(int amount, int[] coins, int index,int[][] dp){
        if(amount==0) return 1;
        if(amount<0 || index==coins.length) return 0;
        if(dp[index][amount]!=-1) return dp[index][amount];

        int taken = changeMemoizationHelper(amount-coins[index], coins, index, dp);
        int skip = changeMemoizationHelper(amount, coins, index+1, dp);

        return dp[index][amount]=taken+skip;
    }

    public static int changeRecursion(int amount, int[] coins) {
        return changeRecursionHelper(amount, coins, 0);
    }
    public static int changeRecursionHelper(int amount, int[] coins, int index){
        if(amount==0) return 1;
        if(amount<0 || index==coins.length) return 0;
        int taken = changeRecursionHelper(amount-coins[index], coins, index);
        int notTaken = changeRecursionHelper(amount, coins, index+1);
        return taken+notTaken;
    }
}
