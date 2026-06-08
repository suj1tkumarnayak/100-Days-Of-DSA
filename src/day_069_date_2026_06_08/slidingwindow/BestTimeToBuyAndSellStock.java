package day_069_date_2026_06_08.slidingwindow;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        // TODO: Implement your logic here
        int max = 0;
        int n = prices.length;
        int maxPrice = 0;
        int minPrice = 0;

        for (int i = 1; i < n; i++) {
            int num = prices[i];
            //if(num>)
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();

        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1 - Expected: 5, Actual: " + solver.maxProfit(prices1));

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test 2 - Expected: 0, Actual: " + solver.maxProfit(prices2));
    }
}
