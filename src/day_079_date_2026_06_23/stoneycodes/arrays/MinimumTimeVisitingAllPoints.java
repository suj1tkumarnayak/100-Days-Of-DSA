package day_079_date_2026_06_23.stoneycodes.arrays;

public class MinimumTimeVisitingAllPoints {

    public static void main(String[] args) {
        MinimumTimeVisitingAllPoints solution = new MinimumTimeVisitingAllPoints();

        // Test Case 1: Standard case with mixed movements (diagonal + straight lines)
        int[][] test1 = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println("Test Case 1: [[1,1],[3,4],[-1,0]] | Expected: 7");
        System.out.println("Simulation: " + solution.minTimeToVisitAllPointsSimulation(test1));
        System.out.println("Optimal (Math): " + solution.minTimeToVisitAllPointsOptimal(test1));
        System.out.println("--------------------------------------------------");

        // Test Case 2: Pure horizontal or vertical movement
        int[][] test2 = {{3, 2}, {-2, 2}};
        System.out.println("Test Case 2: [[3,2],[-2,2]] | Expected: 5");
        System.out.println("Simulation: " + solution.minTimeToVisitAllPointsSimulation(test2));
        System.out.println("Optimal (Math): " + solution.minTimeToVisitAllPointsOptimal(test2));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Sequential perfectly diagonal steps
        int[][] test3 = {{0, 0}, {1, 1}, {2, 2}};
        System.out.println("Test Case 3: [[0,0],[1,1],[2,2]] | Expected: 2");
        System.out.println("Simulation: " + solution.minTimeToVisitAllPointsSimulation(test3));
        System.out.println("Optimal (Math): " + solution.minTimeToVisitAllPointsOptimal(test3));
    }

    /**
     * Approach 1: Simulation
     * Hint: Simulate moving from one point to the next by decrementing/incrementing
     * the X and Y coordinates simultaneously (diagonally) as much as possible,
     * then finish up the remaining distance on a single axis. Track total seconds.
     * * Time Complexity: Depends on coordinate distances
     * Space Complexity: O(1)
     */
    public int minTimeToVisitAllPointsSimulation(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {
            // first point
            int x1 = points[i-1][0];
            int y1 = points[i-1][1];

            int x2 = points[i][0];
            int y2 = points[i][1];

            while (x1 != x2 || y1 != y2 ){
                if(x1<x2){
                    x1++;
                }else if(x1>x2){
                    x1--;
                }

                if(y1<y2){
                    y1++;
                }else if(y1>y2){
                    y1--;
                }
                totalTime++;
            }
        }

        return totalTime;
    }

    /**
     * Approach 2: Optimal (Chebyshev Distance Formula)
     * Hint: Because moving diagonally allows you to cover 1 unit of X and 1 unit of Y
     * in just 1 second, the minimum time to travel between two points $(x_1, y_1)$
     * and $(x_2, y_2)$ is bound entirely by the larger of the two directional differences.
     * Formula: $\max(|x_2 - x_1|, |y_2 - y_1|)$
     * * Time Complexity: O(n) - One clean pass over the points array
     * Space Complexity: O(1)
     */
    public int minTimeToVisitAllPointsOptimal(int[][] points) {
        int totalTime = 0;
        // TODO: Implement mathematical/geometric delta computation here
        return totalTime;
    }
}