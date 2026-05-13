package day_044_date_2026_05_13.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        int minInterval = 0;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int y = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<=y){
                y= Math.min(y, intervals[i][0]);
            }
        }

        return minInterval;
    }
}
