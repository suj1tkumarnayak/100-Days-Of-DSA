package day_063_date_2026_06_01.dailyleetcode;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        int[] cost = {6,5,7,9,2,2};
        System.out.println(minimumCost2(cost));
    }
    public static int minimumCost2(int[] cost){
        Arrays.sort(cost);
        int minCost = 0;
        int n = cost.length;
        for(int i=n-1; i>=0; i--){
            if((n-i)%3!=0){
                minCost+= cost[i];
            }
        }

        return minCost;
    }
    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int n = cost.length;
        int minCost = 0;
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if(count<2){
                minCost += cost[i];
                count++;
            }else{
                count = 0;
            }
        }

        return minCost;
    }
}
