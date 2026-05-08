package day_041_date_2026_05_08.dynamicprogramming;

public class CoinChangeIPractice {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChangeBottomUp(coins, amount));
    }

    public static int coinChangeBottomUp(int[] coins, int amount){
        int n = amount+1;
        if(amount==0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = n;
        }
        for (int i = 1; i < n; i++) {
            for (int coin : coins) {
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==n?-1:dp[amount];
    }

    public static int coinChangeMemoization(int[] coins, int amount){
        int[] dp = new int[amount+1];
        for (int i = 0; i < amount+1; i++) {
            dp[i] = -2;
        }
        int ans = coinChangeMemoizationHelper(coins, amount, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static int coinChangeMemoizationHelper(int[] coins, int amount, int[] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-2) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeMemoizationHelper(coins, amount-coin, dp);
            if(res!=Integer.MAX_VALUE){
                min = Math.min(min, 1+res);
            }
        }
        return dp[amount]=min;
    }

    public static int coinChangeRecursion(int[] coins, int amount){
        if(amount == 0) return 0;
        int result = coinChangeRecursionHelper(coins, amount);
        return result==Integer.MAX_VALUE?-1:result;
    }
    public static int coinChangeRecursionHelper(int[] coins, int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = coinChangeRecursionHelper(coins, amount-coins[i]);
            if(res!=Integer.MAX_VALUE){
                min = Math.min(min, 1+res);
            }
        }
        return min;
    }
}
