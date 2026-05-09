package day_042_date_2026_05_09.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcdee";
        String text2 = "ace";
        System.out.println(lcsBottomUp(text1, text2));
    }
    public static int lcsBottomUp(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] += 1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return 1;
    }
    public static int lcsMemoization(String text1, String text2){
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return lcsMemoizationHelper(text1, text2, 0, 0, dp);
    }
    public static int lcsMemoizationHelper(String text1, String text2, int i, int j, int[][] dp){
        if(i==text1.length() || j==text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j]=1+lcsMemoizationHelper(text1, text2, i+1, j+1, dp);
        }else{
            dp[i][j] = Math.max(lcsMemoizationHelper(text1, text2, i+1, j, dp), lcsMemoizationHelper(text1, text2, i, j+1, dp));
        }
        return dp[i][j];
    }
    public static int lcsRecursion(String text1, String text2){
        return lcsRecursionHelper(text1, text2, 0, 0);
    }
    public static int lcsRecursionHelper(String text1, String text2, int i, int j){
        if(i==text1.length() || j==text2.length()) return 0;
        int sum;
        if(text1.charAt(i)==text2.charAt(j)){
            sum=1+lcsRecursionHelper(text1, text2, i+1, j+1);
        }else{
            sum = Math.max(lcsRecursionHelper(text1, text2, i+1, j), lcsRecursionHelper(text1, text2, i, j+1));
        }
        return sum;
    }
}
