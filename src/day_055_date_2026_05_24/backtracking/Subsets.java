package day_055_date_2026_05_24.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {1, 2, 3};
        // Expected: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
        System.out.println("Test 1 Result: " + subsets(nums1));

        // Test Case 2
        int[] nums2 = {0};
        // Expected: [[], [0]]
        System.out.println("Test 2 Result: " + subsets(nums2));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Implement the subset generation logic here
        return result;
    }

    public static List<List<Integer>> recursionHelper(int[] nums)
}
