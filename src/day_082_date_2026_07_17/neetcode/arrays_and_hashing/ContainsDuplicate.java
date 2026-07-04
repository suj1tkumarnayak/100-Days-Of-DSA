package day_082_date_2026_07_17.neetcode.arrays_and_hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

public class ContainsDuplicate {

    public static void main(String[] args) {
        // Test Cases: {Input Array, Expected Boolean Output}
        Object[][] testCases = {
                {new int[]{1, 2, 3, 1}, true},                         // Duplicates present
                {new int[]{1, 2, 3, 4}, false},                        // All unique
                {new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true},       // Multiple duplicates
                {new int[]{}, false},                                  // Edge Case: Empty array
                {new int[]{10}, false}                                 // Edge Case: Single element
        };

        ContainsDuplicate solver = new ContainsDuplicate();

        // Run the test cases against each of the three approaches
        runTests("1. Brute Force (O(N^2))", solver::containsDuplicateBruteForce, testCases);
        runTests("2. Sorting (O(N log N))", solver::containsDuplicateSorting, testCases);
        runTests("3. Hash Set (O(N))", solver::containsDuplicateHashSet, testCases);
    }

    /**
     * Helper method to run and print the test results dynamically.
     */
    private static void runTests(String approachName, Function<int[], Boolean> algorithm, Object[][] testCases) {
        System.out.println("==================================================");
        System.out.println(" RUNNING TESTS FOR: " + approachName);
        System.out.println("==================================================");

        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            int[] nums = (int[]) testCases[i][0];
            boolean expected = (boolean) testCases[i][1];

            // We pass a clone so sorting approaches don't mutate the original test case array for subsequent tests
            boolean result = algorithm.apply(nums.clone());

            if (result == expected) {
                passed++;
                System.out.println("Test " + (i + 1) + ": PASS | Input: " + Arrays.toString(nums) + " -> Output: " + result);
            } else {
                System.out.println("Test " + (i + 1) + ": FAIL | Input: " + Arrays.toString(nums) + " | Expected: " + expected + " | Got: " + result);
            }
        }
        System.out.println("Result: " + passed + "/" + testCases.length + " tests passed.\n");
    }

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(N^2) | Space Complexity: O(1)
     * * Strategy:
     * - Use nested loops to compare every element with every other element.
     * - If a match is found, immediately return true.
     */
    public boolean containsDuplicateBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2: Sorting
     * Time Complexity: O(N log N) | Space Complexity: O(1) (or O(N) depending on the sorting algorithm)
     * * Strategy:
     * - Sort the array first.
     * - Once sorted, any duplicate elements will be adjacent to each other.
     * - Iterate through the array once and check if nums[i] == nums[i - 1].
     */
    public boolean containsDuplicateSorting(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }

    /**
     * Approach 3: Hash Set (Most Optimal)
     * Time Complexity: O(N) | Space Complexity: O(N)
     * * Strategy:
     * - Utilize a Hash Set to keep track of elements we've seen so far.
     * - As we iterate through the array, check if the current element is already in the set.
     * - If it is, we've found a duplicate! If not, add it to the set and keep moving.
     */
    public boolean containsDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }

    public boolean containsDuplicateHashSetStream(int[] nums) {
        return Arrays.stream(nums).distinct().count()< nums.length;
    }
}