package day_056_date_2026_05_25.sample;


import java.util.Comparator;
import java.util.PriorityQueue;

public class FoodStamps {
    class Pair{
        int currValue;
        int decreasingValue;
        Pair(int currValue, int decreasingValue){
            this.currValue = currValue;
            this.decreasingValue = decreasingValue;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        int v[] = {5, 7, 9};
        int d[] = {2, 4, 6};
        FoodStamps fs = new FoodStamps();
        System.out.println(fs.maxFoodPoints(n, m, v, d));
    }
    public int maxFoodPoints(int n, int m, int[] v, int d[]){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->Integer.compare(b.currValue, a.currValue));

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(v[i], d[i]));
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            Pair top = pq.poll();

            if(top.currValue==0) break;
            ans += top.currValue;

            top.currValue -= top.decreasingValue;
            pq.offer(top);
        }

        return ans;
    }
}
