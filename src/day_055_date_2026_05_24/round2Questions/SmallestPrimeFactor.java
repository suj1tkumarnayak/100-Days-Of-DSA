package day_055_date_2026_05_24.round2Questions;

import java.util.Arrays;
import java.util.HashSet;

public class SmallestPrimeFactor {

    public static void main(String[] args) {
        // Mock Inputs
        int num1 = 25;
        int num2 = 14;
        int num3 = 19;
        int num4 = 4;

        SmallestPrimeFactor solution = new SmallestPrimeFactor();

        // Updated print statements to match your return type
        System.out.println("Result for " + num1 + " is: " + Arrays.toString(solution.getSmallestPrimeFactor(num1)));
        System.out.println("Result for " + num2 + " is: " + Arrays.toString(solution.getSmallestPrimeFactor(num2)));
        System.out.println("Result for " + num3 + " is: " + Arrays.toString(solution.getSmallestPrimeFactor(num3)));
        System.out.println("Result for " + num4 + " is: " + Arrays.toString(solution.getSmallestPrimeFactor(num4)));

    }

    public int[] getSmallestPrimeFactors(int n){
        int[] nums = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            nums[i] = i;
        }

        for (int i = 2; i*i <= n; i++) {
            if(nums[i]==i){
                for (int j = i*i; j <= n; j+=i) {
                    if(nums[j] == j){
                        nums[j] = i;
                    }
                }
            }
        }

        return nums;
    }

    public int[] getSmallestPrimeFactor(int n) {
        HashSet<Integer> primesList = listOfPrimes(n);
        int[] nums = new int[n+1];
        nums[1] = 1;
        for (int i = 2; i < n+1; i++) {
            if(primesList.contains(i)){
                nums[i] = i;
            }else{
                nums[i] = divisibleBy(primesList, i);
            }
        }

        return nums;
    }

    public int divisibleBy(HashSet<Integer> set, int i){
        int smallestDiv = Integer.MAX_VALUE;
        for (int d : set) {
            if(i%d==0){
                smallestDiv = Math.max(d, smallestDiv);
            }
        }
        return smallestDiv;
    }
    public HashSet<Integer> listOfPrimes(int n){
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        HashSet<Integer> primesList = new HashSet<>();

        for (int i = 2; i < n+1; i++) {
            if(primes[i]){
                primesList.add(i);
                int j = i*2;
                while (j<n+1){
                    primes[j] = false;
                    j += i;
                }
            }
        }

        return primesList;
    }
}
