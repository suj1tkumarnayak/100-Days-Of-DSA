package day_079_date_2026_06_23.stoneycodes.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllTheNumbersDissappearedInAnArray {

    public static void main(String[] args) {
        FindAllTheNumbersDissappearedInAnArray solution = new FindAllTheNumbersDissappearedInAnArray();

        // Test Case 1: Standard case with multiple duplicates and missing numbers
        int[] test1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Test Case 1: [4,3,2,7,8,2,3,1] | Expected: [5, 6]");
        System.out.println("Better (HashSet): " + solution.findDisappearedNumbersBetterSet(test1.clone()));
        System.out.println("Better (Freq Array): " + solution.findDisappearedNumbersBetterArray(test1.clone()));
        System.out.println("Optimal (In-place): " + solution.findDisappearedNumbersOptimal(test1.clone()));
        System.out.println("--------------------------------------------------");

        // Test Case 2: Minimal case where all numbers are identical
        int[] test2 = {1, 1};
        System.out.println("Test Case 2: [1, 1] | Expected: [2]");
        System.out.println("Better (HashSet): " + solution.findDisappearedNumbersBetterSet(test2.clone()));
        System.out.println("Better (Freq Array): " + solution.findDisappearedNumbersBetterArray(test2.clone()));
        System.out.println("Optimal (In-place): " + solution.findDisappearedNumbersOptimal(test2.clone()));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Edge case where no numbers are missing
        int[] test3 = {1, 2, 3, 4};
        System.out.println("Test Case 3: [1, 2, 3, 4] | Expected: []");
        System.out.println("Better (HashSet): " + solution.findDisappearedNumbersBetterSet(test3.clone()));
        System.out.println("Better (Freq Array): " + solution.findDisappearedNumbersBetterArray(test3.clone()));
        System.out.println("Optimal (In-place): " + solution.findDisappearedNumbersOptimal(test3.clone()));
    }

    /**
     * Approach 1: Better (Using HashSet)
     * Hint: Add all numbers of the array into a Set. Then loop from 1 to n
     * and check if the number exists in the Set.
     */
    public List<Integer> findDisappearedNumbersBetterSet(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * Approach 2: Better (Using a Frequency / Counting Array)
     * Hint: Create a boolean array or integer array of size n + 1.
     * Mark the indices corresponding to the elements seen in `nums`.
     */
    public List<Integer> findDisappearedNumbersBetterArray(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] numbers = new int[n+1];

        for (int num : nums) {
            numbers[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if(numbers[i]==0){
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     * Approach 3: Optimal (In-place Modification / Negative Tagging)
     * Hint: Since numbers are in the range [1, n], you can treat the values as indices.
     * Walk through the array, treat `Math.abs(nums[i]) - 1` as an index, and flip the
     * value at that index to negative. Any index that remains positive is missing!
     */
    public List<Integer> findDisappearedNumbersOptimal(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
//        0, 1, 2, 3, 4, 5, 6, 7
//        4, 3, 2, 7, 8, 2, 3, 1
//
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i])-1;

            if(nums[index]>0){
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                ans.add(i+1);
            }
        }

        return ans;
    }
}