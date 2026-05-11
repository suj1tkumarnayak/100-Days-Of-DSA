package day_042_date_2026_05_09.revision;

import java.util.Arrays;

public class CoinChangeI {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChangeBottomUp(coins, amount));
    }
    public static int coinChangeBottomUp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
    public static int coinChangeMemoization(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -2);
        int min = coinChangeMemoizationHelper(coins, amount, dp);
        return min==Integer.MAX_VALUE?-1:min;
    }
    public static int coinChangeMemoizationHelper(int[] coins, int amount, int[] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-2) return dp[amount];
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChangeMemoizationHelper(coins, amount-coin, dp);
            if(res!=Integer.MAX_VALUE){
                res = 1+res;
                min = Math.min(min, res);
            }
        }

        return dp[amount]=min;
    }
    public static int coinChangeRecursion(int[] coins, int amount) {
        int min = coinChangeRecursionHelper(coins, amount);
        return min==Integer.MAX_VALUE?-1:min;
    }
    public static int coinChangeRecursionHelper(int[] coins, int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = coinChangeRecursionHelper(coins, amount-coin);
            if(res!=Integer.MAX_VALUE){
                res = 1+res;
                min = Math.min(min, res);
            }
        }

        return min;
    }
}
