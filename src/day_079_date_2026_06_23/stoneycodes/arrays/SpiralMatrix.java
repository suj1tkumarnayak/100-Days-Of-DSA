package day_079_date_2026_06_23.stoneycodes.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();

        // Test Case 1: Standard 3x3 square matrix
        int[][] test1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Test Case 1: 3x3 Matrix | Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]");
        System.out.println("Visited Simulation: " + solution.spiralOrderVisitedSimulation(test1));
        System.out.println("Optimal Boundaries: " + solution.spiralOrderBoundaryOptimal(test1));
        System.out.println("--------------------------------------------------");

        // Test Case 2: 3x4 rectangular matrix (Uneven rows and columns)
        int[][] test2 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };
        System.out.println("Test Case 2: 3x4 Matrix | Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]");
        System.out.println("Visited Simulation: " + solution.spiralOrderVisitedSimulation(test2));
        System.out.println("Optimal Boundaries: " + solution.spiralOrderBoundaryOptimal(test2));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Edge Case - Single row matrix
        int[][] test3 = {
                {1, 2, 3, 4}
        };
        System.out.println("Test Case 3: 1x4 Matrix | Expected: [1, 2, 3, 4]");
        System.out.println("Visited Simulation: " + solution.spiralOrderVisitedSimulation(test3));
        System.out.println("Optimal Boundaries: " + solution.spiralOrderBoundaryOptimal(test3));
    }

    /**
     * Approach 1: Better (Simulation with Visited Matrix)
     * Hint: Set up direction vectors for Right, Down, Left, and Up movements.
     * Maintain a boolean[][] visited matrix of the same size. Walk straight
     * until you hit a matrix edge or a visited cell, then turn 90 degrees right.
     * * Time Complexity: O(m * n)
     * Space Complexity: O(m * n) due to the extra tracking grid
     */
    public List<Integer> spiralOrderVisitedSimulation(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        int[][] directions = {
                {0 , 1}, // right
                {1, 0}, // down
                {0, -1}, // left
                {-1, 0} // up
        };
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int d = 0;

        int r = 0, c = 0;

        while (r>=0 && r<m && c>=0 && c<n && !visited[r][c]){
            ans.add(matrix[r][c]);
            visited[r][c] = true;
            //check whether going in direction d possible
            int tr = r + directions[d][0];
            int tc = c + directions[d][1];

            if(tr<0 || tr>=m || tc<0 || tc>=n || visited[tr][tc]){
                d = (d+1)%4;
            }

            r += directions[d][0];
            c += directions[d][1];
        }

        return ans;
    }

    /**
     * Approach 2: Optimal (Layer-by-Layer Boundary Shrinking)
     * Hint: Define four explicit boundary pointers: `top` (0), `bottom` (m-1),
     * `left` (0), and `right` (n-1). Read elements from left-to-right along the top,
     * top-to-bottom along the right, right-to-left along the bottom, and bottom-to-top
     * along the left. Shrink the respective boundary inward after finishing each line.
     * * Time Complexity: O(m * n)
     * Space Complexity: O(1) auxiliary space (excluding the output list)
     */
    public List<Integer> spiralOrderBoundaryOptimal(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m-1;
        int leftMost = 0;
        int rightMost = n-1;

        while (top<=bottom && leftMost<=rightMost){
            // Top row
            for (int col = leftMost; col <= rightMost; col++) {
                ans.add(matrix[top][col]);
            }
            top++;

            // right most column
            for (int row = top; row <= bottom; row++) {
                ans.add(matrix[row][rightMost]);
            }
            rightMost--;

            // bottom row
            if(top<=bottom){
                for (int col = rightMost; col >= leftMost; col--) {
                    ans.add(matrix[bottom][col]);
                }
                bottom--;
            }

            // left most column

            if(leftMost<=rightMost){
                for (int row = bottom; row >= top ; row--) {
                    ans.add(matrix[row][leftMost]);
                }
                leftMost++;
            }
        }

        return ans;
    }
}