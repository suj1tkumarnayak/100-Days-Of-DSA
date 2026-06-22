package day_078_date_2026_06_21.dailyproblems;

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int[] costs = { 1, 3, 2, 4, 1 };
        int coins = 7;
        System.out.println();
    }
    public static int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[coins+1];

        for (int cost : costs) {
            freq[cost]++;
        }
        int count = 0;



        return count;
    }
}
