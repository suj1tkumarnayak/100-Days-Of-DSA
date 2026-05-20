package day_051_date_2026_05_20.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int[] val = {1, 2, 3};
        int[] wt =  {4, 5, 1};
        int W = 6;
        System.out.println(knapsackBottomUp2D(W, val, wt));
    }

    public static int knapsackBottomUp2D(int W, int val[], int wt[]){
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for (int i = 1; i < n+1; i++) {
            for (int w = 1; w < W+1; w++) {
                if(wt[i-1]>w){
                    dp[i][w] = dp[i-1][w];
                }else{
                    dp[i][w] = Math.max(val[i-1]+dp[i-1][w-wt[i-1]], dp[i-1][w]);
                }
            }
        }

        return dp[n][W];
    }

    public static int knapsackRecursion(int W, int val[], int wt[]) {
        int[][] dp = new int[wt.length][W+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(W, val, wt, wt.length-1, dp);
    }
    public static int helper(int w, int[] val, int[] wt, int n, int[][] dp){
        if(n<0 || w<=0){
            return 0;
        }

        int memo = dp[n][w];
        if(memo!=-1) return memo;

        if(wt[n]>w){
            return helper(w, val, wt, n-1, dp);
        }
        int take = val[n]+helper(w-wt[n], val, wt, n-1, dp);
        int skip = helper(w, val, wt, n-1, dp);

        return dp[n][w]=Math.max(take, skip);
    }
}
