package day_041_date_2026_05_08.dynamicprogramming;

public class climbingStairs {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(climbStairs(n));
    }
    public static int climbStairsRecursion(int n){
        if(n==0) return 1;
        if(n<0) return 0;
        int one = climbStairsRecursion(n-1);
        int two = climbStairsRecursion(n-2);
        return one+two;
    }
    public static int climbStairs(int n){
        int[] dp = new int[n];
        if(n==1) return 1;
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n-1];
    }
}
