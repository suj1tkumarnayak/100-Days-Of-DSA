package day_041_date_2026_05_08.bitmanipulation;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(Arrays.toString(countBitsTree(num)));
    }
    public static int[] countBits(int num){
        int[] nums = new int[num+1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = countingBitsHelper(i);
        }
        return nums;
    }
    public static int hammingWeight(int num){
        int sum = 0;
        while(num>0){
            sum += (num&1);
            num>>=1;
        }
        return sum;
    }
    public static int countingBitsHelper(int num){
        int sum = 0;

        while(num>0){
            sum+=(num%2);
            num/=2;
        }
        return sum;
    }
    public static int[] countBitsOptimized(int num){
        int[] dp = new int[num+1];

        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i>>1]+(i&1);
        }

        return dp;
    }
    public static int[] brianKernighanRelation(int n){
        int[] dp = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            dp[i] = dp[i&(i-1)]+1;
        }

        return dp;
    }
    public static int[] countBitsTree(int n) {
        int[] ans = new int[n + 1];
        build(ans, 1, 1, n);
        return ans;
    }
    private static void build(int[] ans, int bit, int num, int n){
        if(num > n || ans[num] != 0) return;
        ans[num] = bit;
        build(ans, bit, num << 1, n);
        build(ans, bit + 1, (num << 1 | 1), n);
    }
}
