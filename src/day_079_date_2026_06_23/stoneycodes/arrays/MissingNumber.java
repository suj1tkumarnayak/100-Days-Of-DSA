package day_079_date_2026_06_23.stoneycodes.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();

        // Test Case 1: Standard case with a missing number in the middle
        int[] test1 = {3, 0, 1};
        System.out.println("Test Case 1: [3, 0, 1] | Expected: 2");
        System.out.println("Brute Force: " + solution.missingNumberBruteForce(test1));
        System.out.println("Better (Set): " + solution.missingNumberBetter(test1));
        System.out.println("Optimal (Math): " + solution.missingNumberOptimalMath(test1));
        System.out.println("Optimal (XOR): " + solution.missingNumberOptimalXor(test1));
        System.out.println("--------------------------------------------------");

        // Test Case 2: Missing number is the last number (n itself)
        int[] test2 = {0, 1};
        System.out.println("Test Case 2: [0, 1] | Expected: 2");
        System.out.println("Brute Force: " + solution.missingNumberBruteForce(test2));
        System.out.println("Better (Set): " + solution.missingNumberBetter(test2));
        System.out.println("Optimal (Math): " + solution.missingNumberOptimalMath(test2));
        System.out.println("Optimal (XOR): " + solution.missingNumberOptimalXor(test2));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Larger array missing a number in the sequence
        int[] test3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Test Case 3: [9, 6, 4, 2, 3, 5, 7, 0, 1] | Expected: 8");
        System.out.println("Brute Force: " + solution.missingNumberBruteForce(test3));
        System.out.println("Better (Set): " + solution.missingNumberBetter(test3));
        System.out.println("Optimal (Math): " + solution.missingNumberOptimalMath(test3));
        System.out.println("Optimal (XOR): " + solution.missingNumberOptimalXor(test3));
    }

    /**
     * Approach 1: Brute Force
     * Hint: Think about sorting the array first.
     */
    public int missingNumberBruteForce(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if(i!=nums[i]){
                return i;
            }
        }

        return n;
    }

    /**
     * Approach 2: Better
     * Hint: Think about using extra space like a HashSet for O(1) lookups.
     */
    public int missingNumberBetter(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }

    /**
     * Approach 3: Optimal (Math)
     * Hint: Use the formula for the sum of the first n natural numbers.
     */
    public int missingNumberOptimalMath(int[] nums) {
        int n = nums.length;
        int totalSum = ((n+1)*n)/2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return totalSum-sum;
    }

    /**
     * Approach 4: Optimal (Bit Manipulation)
     * Hint: Think about how XORing a number by itself results in 0.
     */
    public int missingNumberOptimalXor(int[] nums) {
        int n = nums.length;
        int num = n;
        for (int i = 0; i < n; i++) {
            num^=i;
            num^=nums[i];
        }
        return num;
    }
}