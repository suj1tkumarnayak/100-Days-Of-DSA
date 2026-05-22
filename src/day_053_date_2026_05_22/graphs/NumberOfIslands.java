package day_053_date_2026_05_22.graphs;

public class NumberOfIslands {
    static int rows;
    static int cols;
    public static void main(String[] args) {
        // Setup Example 1
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int result1 = numIslands(grid1);
        System.out.println("Example 1 Output: " + result1+" expected: 1"); // Expected: 1

        // Setup Example 2
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int result2 = numIslands(grid2);
        System.out.println("Example 2 Output: " + result2+ " expected: 3"); // Expected: 3
    }
    public static int numIslands(char[][] grid) {
        rows = grid.length;
        cols= grid[0].length;
        int noOfIslands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    noOfIslands++;
                }
            }
        }

        return noOfIslands;
    }
    public static void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r>=rows || c>=cols){
            return;
        }
        if(grid[r][c]=='1'){
            grid[r][c] = '#';
            dfs(grid, r+1, c);
            dfs(grid, r, c+1);
            dfs(grid, r-1, c);
            dfs(grid, r, c-1);
        }
    }
}
