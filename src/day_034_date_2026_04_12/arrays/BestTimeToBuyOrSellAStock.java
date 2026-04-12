package day_034_date_2026_04_12.arrays;

public class BestTimeToBuyOrSellAStock {
    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfitBrute(nums));
    }

    private static int maxProfitBrute(int[] prices) {
        int profit = 0, len = prices.length;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int prof = prices[j] - prices[i];
                profit = Math.max(profit, prof);
            }
        }

        return profit;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0, len = prices.length, minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int price = prices[i];
            if(price<minPrice){
                minPrice = price;
            }else{
                int prof = price - minPrice;
                profit = Math.max(profit, prof);
            }
        }

        return profit;
    }
}
