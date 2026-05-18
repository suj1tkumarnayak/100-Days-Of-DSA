package day_049_date_2026_05_18.sheet.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChangeRecursion(coins, amount));
    }
    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            for (int coin : coins) {
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }

        }

        return dp[amount]==amount+1?-1:dp[amount];
    }
    private static int coinChangeRecursion(int[] coins, int amount){
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row : dp) {
            Arrays.fill(row, -2);
        }
        int ans = helper(coins, amount, 0, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private static int helper(int[] coins, int amount, int index, int[][] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(index==coins.length) return Integer.MAX_VALUE;
        if(dp[index][amount]!=-2) return dp[index][amount];
        // take
        int take = Integer.MAX_VALUE;
        int currTake = helper(coins, amount-coins[index], index, dp);
        if(currTake!=Integer.MAX_VALUE){
            take = 1+currTake;
        }
        //skip
        int skip = helper(coins, amount, index+1, dp);

        return dp[index][amount]=Math.min(take, skip);
    }
}
