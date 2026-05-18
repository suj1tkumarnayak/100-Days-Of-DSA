package day_049_date_2026_05_18.sheet.dynamicprogramming;

import java.util.Arrays;

public class KnapSack_0_1 {
    public static void main(String[] args) {
        int w = 5;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 2, 3};
        System.out.println(knapsack(w, val, wt));
    }
    private static int knapsack(int w, int[] val, int[] wt) {

        int n = wt.length;

        int[] dp = new int[w + 1];

        for (int i = 0; i < n; i++) {

            for (int cap = w; cap >= wt[i]; cap--) {

                dp[cap] = Math.max(
                        dp[cap],
                        val[i] + dp[cap - wt[i]]
                );
            }
        }

        return dp[w];
    }
    private static int knapsackRecursion(int w, int[] val, int[] wt){
        int[][] dp = new int[wt.length][w+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(w, val, wt, wt.length-1, dp);
    }
    private static int solve(int w, int[] val, int[] wt, int ind, int[][] dp){
        if(ind==0){
            if(wt[0]<=w){
                return val[0];
            }
            return 0;
        }

        if(dp[ind][w]!=-1) return dp[ind][w];

        // skip
        int skip = solve(w, val, wt, ind-1, dp);

        //
        int take = Integer.MIN_VALUE;
        if(wt[ind]<=w){
            take = val[ind] + solve(w-wt[ind], val, wt, ind-1, dp);
        }

        return dp[ind][w]=Math.max(take, skip);
    }
}
