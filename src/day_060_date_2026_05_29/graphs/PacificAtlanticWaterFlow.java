package day_060_date_2026_05_29.graphs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    static int rows;
    static int cols;

    static int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) {

        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = pacificAtlantic(heights);

        System.out.println(result);
    }

    static List<List<Integer>> pacificAtlantic(int[][] heights) {

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // DFS from Pacific borders

        // top row
        for (int col = 0; col < cols; col++) {

        }

        // left column
        for (int row = 0; row < rows; row++) {

        }

        // DFS from Atlantic borders

        // bottom row
        for (int col = 0; col < cols; col++) {

        }

        // right column
        for (int row = 0; row < rows; row++) {

        }

        List<List<Integer>> result = new ArrayList<>();

        // collect cells reachable by both oceans
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (pacific[row][col] && atlantic[row][col]) {

                    List<Integer> cell = new ArrayList<>();

                    cell.add(row);
                    cell.add(col);

                    result.add(cell);
                }
            }
        }

        return result;
    }

    static void dfs(int[][] heights,
                    int row,
                    int col,
                    boolean[][] ocean) {

    }
}