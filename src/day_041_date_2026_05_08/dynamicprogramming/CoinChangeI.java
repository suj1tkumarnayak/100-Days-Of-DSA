package day_041_date_2026_05_08.dynamicprogramming;

public class CoinChangeI {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount){
        int[] dp = new int[amount+1];

        for (int i = 1; i < amount+1; i++) {
            dp[i] = amount+1;
        }

        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            for(int coin: coins){
                if(i-coin>=0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }

        return dp[amount]>amount?-1:dp[amount];
    }

    private static int coinChangeMemoization(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 0; i < amount+1; i++) {
            dp[i] = -2;
        }
        int ans = helper(coins, amount, dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public static int helper(int[] coins, int amount, int[] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-2) return dp[amount];

        int min = Integer.MAX_VALUE;

        for(int coin: coins){
            int res = helper(coins, amount-coin, dp);
            if(res!=Integer.MAX_VALUE){
                min = Math.min(min, res+1);
            }
        }

        return dp[amount]=min;
    }

    public static int coinChangeRecursion(int[] coins, int amount){

        int ans = helper(coins, amount);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int helper(int[] coins, int amount){

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

        int min = Integer.MAX_VALUE;

        for(int coin : coins){

            int res = helper(coins, amount - coin);

            if(res != Integer.MAX_VALUE){

                min = Math.min(min, 1 + res);
            }
        }

        return min;
    }
}
