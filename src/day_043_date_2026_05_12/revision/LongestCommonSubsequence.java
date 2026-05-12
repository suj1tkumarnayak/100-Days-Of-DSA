package day_043_date_2026_05_12.revision;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequenceDP2(text1, text2));
    }
    public static int longestCommonSubsequenceDP1(String text1, String text2){
        int n = text1.length(), m= text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public static int longestCommonSubsequenceDP2(String text1, String text2){
        int n = text1.length(), m= text2.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
    public static int longestCommonSubsequenceMemoization(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return longestCommonSubsequenceMemoizationHelper(text1, text2, 0, 0, dp);
    }
    public static int longestCommonSubsequenceMemoizationHelper(String text1, String text2, int i, int j, int[][] dp){
        if(i==text1.length() || j==text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j]=1+longestCommonSubsequenceRecursionHelper(text1, text2, i+1, j+1);
        }else{
            return dp[i][j]=Math.max(longestCommonSubsequenceRecursionHelper(text1, text2, i+1, j),
                    longestCommonSubsequenceRecursionHelper(text1, text2, i, j+1));
        }
    }
    public static int longestCommonSubsequenceRecursion(String text1, String text2) {
        return longestCommonSubsequenceRecursionHelper(text1, text2, 0, 0);
    }
    public static int longestCommonSubsequenceRecursionHelper(String text1, String text2, int i, int j){
        if(i==text1.length() || j==text2.length()) return 0;

        if(text1.charAt(i) == text2.charAt(j)){
            return 1+longestCommonSubsequenceRecursionHelper(text1, text2, i+1, j+1);
        }else{
            return Math.max(longestCommonSubsequenceRecursionHelper(text1, text2, i+1, j),
                    longestCommonSubsequenceRecursionHelper(text1, text2, i, j+1));
        }
    }
}
