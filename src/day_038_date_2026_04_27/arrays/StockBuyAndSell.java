package day_038_date_2026_04_27.arrays;

public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
    public static int maxProfitBrute(int[] nums){
        int profit = 0;

        for (int i = 0; i < nums.length; i++) {
            int currProfit = 0;
            for (int j = i+1; j < nums.length; j++) {
                currProfit = Math.max(currProfit, nums[j]-nums[i]);
            }
            profit = Math.max(profit, currProfit);
        }

        return profit;
    }
    public static int maxProfit(int[] nums){
        int profit = 0;
        int currMin = Integer.MAX_VALUE;
        int currProfit;
        for (int i = 0; i < nums.length; i++) {
            currMin = Math.min(currMin, nums[i]);
            currProfit = nums[i]-currMin;
            profit = Math.max(profit, currProfit);
        }
        return profit;
    }
}
