package day_053_date_2026_05_22.bitmanipulation;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBitsDPOptimal(n)));
    }
    public static int[] countBitsDPOptimal(int n){
        int[] dp = new int[n+1];

        for (int i = 1; i <= n ; i++) {
            dp[i] = dp[i>>1]+(i&1);
        }

        return dp;
    }
    public static int[] countBitsDP(int n){
        int[] dp = new int[n+1];
        int offset = 1;

        for (int i = 1; i <= n; i++) {
            if(offset*2==i){
                offset = i;
            }
            dp[i] = 1 + dp[i-offset];
        }

        return dp;
    }
    public static int[] countBits(int n){
        int[] count = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            count[i] = hammingWeight(i);
        }

        return count;
    }
    public static int hammingWeight(int n){
        int count = 0;

        while (n>0){
            n = n&(n-1);
            count++;
        }

        return count;
    }
}
