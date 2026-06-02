package day_065_date_2026_06_03.arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        // Test Case 1: Standard fluctuating prices
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit 1: " + maxProfit(prices1)); // Expected: 5 (Buy at 1, Sell at 6)

        // Test Case 2: Prices strictly decreasing (No profit possible)
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Max Profit 2: " + maxProfit(prices2)); // Expected: 0

        // Test Case 3: Prices strictly increasing
        int[] prices3 = {1, 2, 3, 4, 5};
        System.out.println("Max Profit 3: " + maxProfit(prices3)); // Expected: 4 (Buy at 1, Sell at 5)
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
//        7, 1, 5, 3, 6, 4
        int maxProfit = 0;
        int lowestYet = 0;
        int highestYet= 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[lowestYet]>prices[i]){
                lowestYet = i;
            }
        }

        return maxProfit;
    }
}
