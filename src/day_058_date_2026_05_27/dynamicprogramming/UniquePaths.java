package day_058_date_2026_05_27.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // fill the base case row 0 = 1
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        //fill the base case column 0 = 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static int uniquePathsRecursion(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, m, n, dp);
    }

    public static int dfs(int row, int col, int m, int n, int[][] dp) {

        // out of bounds
        if (row >= m || col >= n) {
            return 0;
        }
        int memo = dp[row][col];
        if(memo!=-1) return memo;

        // reached destination
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        int down = dfs(row + 1, col, m, n, dp);
        int right = dfs(row, col + 1, m, n, dp);

        return dp[row][col] = down + right;
    }
}
