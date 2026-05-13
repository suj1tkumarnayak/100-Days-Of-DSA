package day_044_date_2026_05_13.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrowsToBurstBalloon {
    public static void main(String[] args) {
        //int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] points = {
                {3, 9},
                {7, 12},
                {3, 8},
                {6, 8},
                {9, 10},
                {2, 9},
                {0, 9},
                {3, 9},
                {0, 6},
                {2, 8}
        };
//        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
//        for (int[] row : points) {
//            System.out.println(Arrays.toString(row));
//        }
        System.out.println(findMinArrowShots(points));
    }
    private static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int minHits = 0;
        int x= points[0][0], y = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>y){
                minHits++;
                x = points[i][0];
                y = points[i][1];
            }
        }

        return minHits+1;
    }
}
