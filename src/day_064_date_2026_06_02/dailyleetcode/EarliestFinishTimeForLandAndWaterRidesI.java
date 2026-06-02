package day_064_date_2026_06_02.dailyleetcode;

import java.util.*;

public class EarliestFinishTimeForLandAndWaterRidesI {

    public static void main(String[] args) {
        EarliestFinishTimeForLandAndWaterRidesI solver = new EarliestFinishTimeForLandAndWaterRidesI();

        // Dummy test data - update these values based on the exact problem description
//        int[] landStartTime = {1, 3, 5};
//        int[] landDuration = {2, 2, 1};
//        int[] waterStartTime = {2, 4};
//        int[] waterDuration = {3, 1};
        int[] landStartTime = {2,8};
        int[] landDuration = {4,1};
        int[] waterStartTime = {6};
        int[] waterDuration = {3};

        int result = solver.earliestFinishTimeBrute(landStartTime, landDuration, waterStartTime, waterDuration);

        System.out.println("Result: " + result);
    }
    public int earliestFinishTimeBrute(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int earliestTime = Integer.MAX_VALUE;
        int m = landStartTime.length, n = waterStartTime.length;
        // try all combinations of Land and water

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int landTime = landStartTime[i]+landDuration[i];
                int totalTime;
                if(landTime>=waterStartTime[j]){
                    totalTime = landTime+waterDuration[j];
                }else{
                    totalTime = landTime+waterDuration[j]+(waterStartTime[j]-landTime);
                }
                earliestTime = Math.min(earliestTime, totalTime);
            }
        }

        // try all combinations of water and land
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int waterTime = waterStartTime[i]+waterDuration[i];
                int totalTime;
                if(waterTime>=landStartTime[j]){
                    totalTime = waterTime+landDuration[j];
                }else{
                    totalTime = waterTime+landDuration[j]+(landStartTime[j]-waterTime);
                }
                earliestTime = Math.min(earliestTime, totalTime);
            }
        }
        return earliestTime;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return 0;
    }
}
