package day_056_date_2026_05_25.sample;

import java.util.Arrays;
import java.util.Comparator;

public class FoodStampsFailed {
    class Pair{
        int v;
        int d;
        Pair(int v, int d){
            this.v = v;
            this.d = d;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        int v[] = {5, 7, 9};
        int d[] = {2, 4, 6};
        FoodStampsFailed fs = new FoodStampsFailed();
        System.out.println(fs.maxFoodPoints(n, m, v, d));
    }
    public int maxFoodPoints(int n, int m, int[] v, int d[]){
        // 1st time -> 5-2*(1-1) = 5;
        // 2nd time -> 5-2*(2-1) = 3;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(v[i], d[i]);
        }

        Arrays.sort(pairs, Comparator.comparingInt((Pair a)->a.v).reversed());
        int itemCount = 1;
        int totalItems = 1;
        int maxTastePoints = pairs[0].v;

        int i = 0;
        while (totalItems<m && i<n-1){
            itemCount++;
            int currTastePoints = pairs[i].v - (pairs[i].d*(itemCount-1));

            if(currTastePoints>pairs[i+1].v){
                maxTastePoints+= currTastePoints;
                totalItems++;
            }
            else{
                i++;
                itemCount = 0;
            }
        }

        while (totalItems<m){
            itemCount++;
            maxTastePoints += (pairs[i].v - pairs[i].d*(itemCount-1));
            totalItems++;
        }

        return maxTastePoints;
    }
}
