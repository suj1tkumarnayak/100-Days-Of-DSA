package day_051_date_2026_05_20.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int capacity = 50;
        System.out.println(fractionalKnapsack(val, wt, capacity));
    }
    public static double fractionalKnapsack(int[] val, int[] wt, int capacity){
        double[][] ratio = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = (double) val[i]/wt[i];
            ratio[i][1] = wt[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble((double a[]) -> a[0]).reversed());

        double max = 0;

        for (int i = 0; i < val.length; i++) {
            if(capacity>0){
                if(capacity>=ratio[i][1]){
                    max += ratio[i][0]*ratio[i][1];
                    capacity-= ratio[i][1];
                }else{
                    max += ratio[i][0]*(capacity);
                    break;
                }
            }
        }

        return max;
    }
}
