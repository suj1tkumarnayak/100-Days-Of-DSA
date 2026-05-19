package day_049_date_2026_05_18.sheet.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println(lcsDP(s1, s2));
    }
    public static int lcsDP(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public static int lcs(String s1, String s2) {
        // code here
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row: dp) {
            Arrays.fill(row, -2);
        }

        return recursion(s1, s2, 0, 0, dp);
    }
    public static int recursion(String s1, String s2, int i, int j, int[][] dp){
        if(i>=s1.length() || j>=s2.length()) return 0;
        int memo = dp[i][j];
        if(memo!=-2) return memo;
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j] = 1+recursion(s1, s2, i+1, j+1, dp);
        }
        return dp[i][j] = Math.max(recursion(s1, s2, i+1, j, dp), recursion(s1, s2, i, j+1, dp));
    }
}
