package day_058_date_2026_05_27.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
    public static int longestCommonSubsequence(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
    public static int longestCommonSubsequenceRecursion(String text1, String text2){
        int[][] dp = new int[text1.length()][text2.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(text1, text2, 0, 0, dp);
    }
    public static int dfs(String text1, String text2, int i, int j, int[][] dp){
        if(i>=text1.length() || j>=text2.length()){
            return 0;
        }

        int memo = dp[i][j];

        if(memo!=-1) return memo;


        if(text1.charAt(i)==text2.charAt(j)){
            dp[i][j] = 1+dfs(text1, text2, i+1, j+1, dp);
        }else{
            dp[i][j] = Math.max(dfs(text1, text2, i+1, j, dp), dfs(text1, text2, i, j+1, dp));
        }
        return dp[i][j] ;
    }
}
