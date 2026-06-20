package day_076_date_2026_06_18.dailyproblem;

public class CoverageOfAllZerosInABinaryMatrix {
    public static void main(String[] args) {
        // Test Case 1: Simple 2x2 matrix
        int[][] matrix1 = {
                {0, 1},
                {1, 0}
        };
        System.out.println("Test 1: " + findCoverage(matrix1) + " (Expected: 4)");

        // Test Case 2: 3x3 matrix
        int[][] matrix2 = {
                {0, 1, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        System.out.println("Test 2: " + findCoverage(matrix2) + " (Expected: 6)");

        // Test Case 3: All Zeros (No '1's exist, so coverage must be 0)
        int[][] matrix3 = {
                {0, 0},
                {0, 0}
        };
        System.out.println("Test 3 (All Zeros): " + findCoverage(matrix3) + " (Expected: 0)");

        // Test Case 4: All Ones (No '0's exist, so coverage must be 0)
        int[][] matrix4 = {
                {1, 1},
                {1, 1}
        };
        System.out.println("Test 4 (All Ones): " + findCoverage(matrix4) + " (Expected: 0)");

        // Test Case 5: Single Row Matrix
        int[][] matrix5 = {
                {1, 0, 1}
        };
        // The middle '0' has a '1' on its left and right. Total coverage = 2.
        System.out.println("Test 5 (Single Row): " + findCoverage(matrix5) + " (Expected: 2)");

        // Test Case 6: Single Column Matrix
        int[][] matrix6 = {
                {1},
                {0},
                {1}
        };
        // The middle '0' has a '1' above and below it. Total coverage = 2.
        System.out.println("Test 6 (Single Col): " + findCoverage(matrix6) + " (Expected: 2)");
    }
    static int[][] directions ={
            {0, 1},     // right
            {1, 0},   //  down
            {0, -1},  //   left
            {-1, 0}  //    up
    };
    static int R;
    static int C;
    public static int findCoverage(int[][] mat) {
        int sum = 0;

        R = mat.length;
        C = mat[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(mat[i][j]==0){
                    sum += dfs(mat, i, j, directions[0]);
                    sum += dfs(mat, i, j, directions[1]);
                    sum += dfs(mat, i, j, directions[2]);
                    sum += dfs(mat, i, j, directions[3]);
                }
            }
        }

        return sum;
    }
    public static int dfs(int[][] mat, int r, int c,  int[] dir){
        if(r==R || c==C || r<0 || c<0){
            return 0;
        }
        if(mat[r][c]==1) return 1;

        return dfs(mat, r+dir[0], c+dir[1], dir);
    }
}
