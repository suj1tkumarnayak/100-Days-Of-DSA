package day_040_date_2026_05_07.binary;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
    public static int[] countBits(int n){
        int[] res = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            res[i] = countBitsHelper(i);
        }
        return res;
    }
    public static int countBitsHelper(int n){
        int count = 0;
        if(n==0) return count;
        while (n>0){
            if(n%2==1){
                count++;
            }
            n/=2;
        }
        return count;
    }
}
