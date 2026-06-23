package day_079_date_2026_06_23.stoneycodes.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        // Test Case 1: Standard consecutive elements matching target
        int[] test1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test Case 1: [2, 7, 11, 15], Target: 9 | Expected: [0, 1]");
        System.out.println("Brute Force: " + Arrays.toString(solution.twoSumBruteForce(test1, target1)));
        System.out.println("Optimal (HashMap): " + Arrays.toString(solution.twoSumOptimal(test1, target1)));
        System.out.println("--------------------------------------------------");

        // Test Case 2: Elements are non-consecutive
        int[] test2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Test Case 2: [3, 2, 4], Target: 6 | Expected: [1, 2]");
        System.out.println("Brute Force: " + Arrays.toString(solution.twoSumBruteForce(test2, target2)));
        System.out.println("Optimal (HashMap): " + Arrays.toString(solution.twoSumOptimal(test2, target2)));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Target consists of identical duplicate numbers
        int[] test3 = {3, 3};
        int target3 = 6;
        System.out.println("Test Case 3: [3, 3], Target: 6 | Expected: [0, 1]");
        System.out.println("Brute Force: " + Arrays.toString(solution.twoSumBruteForce(test3, target3)));
        System.out.println("Optimal (HashMap): " + Arrays.toString(solution.twoSumOptimal(test3, target3)));
    }

    /**
     * Approach 1: Brute Force
     * Hint: Use two nested loops to check every single pair combination.
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Approach 2: Optimal (HashMap / One-Pass)
     * Hint: For each number, calculate its complement (target - current_value).
     * Check if that complement already exists as a key inside a HashMap.
     */
    public int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}