package day_055_date_2026_05_24.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5};
        int amount = 11;
        System.out.println(coinChangeRecursion(coins, amount));
    }
    public static int coinChangeDP(int[] coins, int amount){
        int n = coins.length;
        int[][] dp = new int[amount+1][n];

        return 1;
    }
    public static int coinChangeRecursion(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(coins, amount, 0, dp);
    }
    public static int dfs(int[] coins, int amount, int index, int[][] dp){
        if(amount==0) return 0;
        if(amount<0 || index == coins.length) return Integer.MAX_VALUE;

        if(dp[amount][index]!=-1) return dp[amount][index];

        // use the coin
        int take = dfs(coins, amount-coins[index], index, dp);
        if(take!= Integer.MAX_VALUE){
            take = 1 + take;
        }
        // skip the coin
        int skip = dfs(coins, amount, index+1, dp);

        return dp[amount][index] = Math.min(take, skip);
    }
}
