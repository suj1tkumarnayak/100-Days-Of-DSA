package day_049_date_2026_05_18.sheet.dynamicprogramming;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistanceRecursion(word1, word2));
    }

    private static int tabulation(String word1, String word2){
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {

        }
        return 1;
    }

    private static int minDistanceRecursion(String word1, String word2){
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(word1, word2, m-1, n-1, dp);
    }
    private static int helper(String word1, String word2, int i, int j, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        int memo = dp[i][j];
        if(memo!=-1) return memo;

        if(word1.charAt(i)==word2.charAt(j)){
            return helper(word1, word2, i-1, j-1, dp);
        }

        int insert = 1+helper(word1, word2, i, j-1, dp);
        int delete = 1+helper(word1, word2, i-1, j, dp);
        int replace = 1+helper(word1, word2, i-1, j-1, dp);

        return dp[i][j]=Math.min(Math.min(insert, delete), replace);
    }
}
