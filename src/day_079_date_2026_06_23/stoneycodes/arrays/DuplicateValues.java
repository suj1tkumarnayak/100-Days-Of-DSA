package day_079_date_2026_06_23.stoneycodes.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class DuplicateValues {
    public static void main(String[] args) {
        DuplicateValues solver = new DuplicateValues();

        // 3 Test Cases
        int[][] testCases = {
                {1, 2, 3, 1},                        // Case 1: Expected true
                {1, 2, 3, 4},                        // Case 2: Expected false
                {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}       // Case 3: Expected true
        };
        boolean[] expected = {true, false, true};

        // Execution & Verification Loop
        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            System.out.println("--- Test Case " + (i + 1) + ": " + Arrays.toString(nums) + " (Expected: " + expected[i] + ") ---");

            // Pass a clone of the array to prevent sorting methods from modifying original test cases
            System.out.println("Brute Force:   " + solver.containsDuplicateBrute(nums.clone()));
            System.out.println("Better Brute:  " + solver.containsDuplicateBetterBrute(nums.clone()));
            System.out.println("Good (Sort):   " + solver.containsDuplicateGood(nums.clone()));
            System.out.println("Optimal:       " + solver.containsDuplicateOptimal(nums.clone()));
            System.out.println();
        }
    }

    // Approach 1: Brute Force -> O(n²) Time, O(1) Space
    public boolean containsDuplicateBrute(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[j]==nums[i]){
                    return true;
                }
            }
        }
        return false;
    }

    // Approach 2: Better Brute -> O(n²) Time with optimization, O(1) Space
    public boolean containsDuplicateBetterBrute(int[] nums) {
        // TODO: Try early exits, targeted pointer checks, or limited bounds
        return false;
    }

    // Approach 3: Good -> O(n log n) Time, O(1) or O(n) Space depending on sorting algorithm
    public boolean containsDuplicateGood(int[] nums) {
        // TODO: Sort the array first, then check adjacent elements
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-1; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    // Approach 4: Optimal -> O(n) Time, O(n) Space
    public boolean containsDuplicateOptimal(int[] nums) {
        // TODO: Use a high-efficiency collection (like a Set) to find duplicates in one pass
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }

        return false;
    }
}
