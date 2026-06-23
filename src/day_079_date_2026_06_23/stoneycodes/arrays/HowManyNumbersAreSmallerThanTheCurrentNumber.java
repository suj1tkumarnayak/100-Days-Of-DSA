package day_079_date_2026_06_23.stoneycodes.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber solution = new HowManyNumbersAreSmallerThanTheCurrentNumber();

        // Test Case 1: Standard case with mixed duplicates and varying sizes
        int[] test1 = {8, 1, 2, 2, 3};
        System.out.println("Test Case 1: [8, 1, 2, 2, 3] | Expected: [4, 0, 1, 1, 3]");
        System.out.println("Brute Force: " + Arrays.toString(solution.smallerNumbersThanCurrentBruteForce(test1.clone())));
        System.out.println("Better (Sorting): " + Arrays.toString(solution.smallerNumbersThanCurrentSorting(test1.clone())));
        System.out.println("Optimal (Counting): " + Arrays.toString(solution.smallerNumbersThanCurrentCounting(test1.clone())));
        System.out.println("--------------------------------------------------");

        // Test Case 2: All elements are identical
        int[] test2 = {7, 7, 7, 7};
        System.out.println("Test Case 2: [7, 7, 7, 7] | Expected: [0, 0, 0, 0]");
        System.out.println("Brute Force: " + Arrays.toString(solution.smallerNumbersThanCurrentBruteForce(test2.clone())));
        System.out.println("Better (Sorting): " + Arrays.toString(solution.smallerNumbersThanCurrentSorting(test2.clone())));
        System.out.println("Optimal (Counting): " + Arrays.toString(solution.smallerNumbersThanCurrentCounting(test2.clone())));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Elements in varying unsorted sequence
        int[] test3 = {6, 5, 4, 8};
        System.out.println("Test Case 3: [6, 5, 4, 8] | Expected: [2, 1, 0, 3]");
        System.out.println("Brute Force: " + Arrays.toString(solution.smallerNumbersThanCurrentBruteForce(test3.clone())));
        System.out.println("Better (Sorting): " + Arrays.toString(solution.smallerNumbersThanCurrentSorting(test3.clone())));
        System.out.println("Optimal (Counting): " + Arrays.toString(solution.smallerNumbersThanCurrentCounting(test3.clone())));
    }

    /**
     * Approach 1: Brute Force
     * Hint: Use two nested loops. For each element, count how many elements
     * in the entire array are strictly smaller than it.
     * * Time Complexity: O(n^2)
     * Space Complexity: O(1) (excluding the output array)
     */
    public int[] smallerNumbersThanCurrentBruteForce(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(nums[j]<nums[i]) count++;
            }
            result[i] = count;
        }

        return result;
    }

    /**
     * Approach 2: Better (Sorting & Hashing)
     * Hint: Clone the original array and sort it. In a sorted array, the index
     * of the first unique occurrence of a number tells you exactly how many
     * numbers are smaller than it. Store these mappings in a HashMap.
     * * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int[] smallerNumbersThanCurrentSorting(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(copy[i])){
                map.put(copy[i], i);
            }
        }

        for (int i = 0; i < n; i++) {
            result[i] = map.get(nums[i]);
        }

        return result;
    }

    /**
     * Approach 3: Optimal (Counting Sort / Bucket Array)
     * Hint: Assuming array values fall within a specific constraint range (e.g., 0 to 100),
     * build a frequency count array. Transform the frequencies into a running prefix sum
     * array where bucket[i] stores the total count of numbers smaller than value 'i'.
     * * Time Complexity: O(n)
     * Space Complexity: O(1) (Fixed auxiliary bucket array size)
     */
    public int[] smallerNumbersThanCurrentCounting(int[] nums) {
        int[] result = new int[nums.length];
        int[] counting = new int[101];

        // frequncy
        for (int num : nums) {
            counting[num]++;
        }
        // prefix sum
        for (int i = 1; i < 101; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                result[i] = 0;
            }else{
                result[i] = counting[nums[i]-1];
            }
        }

        return result;
    }
}