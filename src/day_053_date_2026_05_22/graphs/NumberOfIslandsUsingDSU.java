package day_053_date_2026_05_22.graphs;

class DSU{
    int[] parent;
    int[] size;

    DSU(int n){
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;

        if(size[rootB]>size[rootA]){
            parent[rootA] = parent[rootB];
            size[rootB] += parent[rootA];
        }else{
            parent[rootB] = parent[rootA];
            size[rootA] += size[rootB];
        }
    }
    boolean conneted(int a, int b){
        return find(a)==find(b);
    }
}
public class NumberOfIslandsUsingDSU {
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
        int rows = grid.length;
        int cols = grid[0].length;
        DSU dsu = new DSU(rows*cols);

        int[][] directions = {
                {-1, 0},
                {0, -1},
                {1, 0},
                {0, 1}
        };

        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c]=='1'){
                    islands++;
                    for(int[] d: directions){
                        int nr = r+d[0];
                        int nc = c+d[1];
                    }
                }
            }
        }

        return islands;
    }
}
