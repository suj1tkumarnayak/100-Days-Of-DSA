package day_054_date_2026_05_23.maths;

import java.util.Arrays;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(countPrimes(n));
    }
    public static int isPrime(int n){
        return 1;
    }
    public static int countPrimes(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        int ans = 0;

        for (int i = 2; i<= n; i++) {
            if(primes[i]){
                ans++;
                int j = i*2;
                while (j<=n){
                    primes[j] = false;
                    j += i;
                }
            }
        }

        return ans;
    }
}
