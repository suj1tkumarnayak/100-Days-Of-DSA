package day_055_date_2026_05_24.arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
// {100, 4, 200, 1, 3, 2}
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;

        for (int num : nums) {
            if(!set.contains(num-1)){
                int len = 0;

                while (set.contains(num)){
                    num++;
                    len++;
                }

                maxLen = Math.max(maxLen, len);
            }
        }


        return maxLen;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2}; // Expected: 4 (sequence: [1, 2, 3, 4])
        System.out.println("Test 1 Result: " + longestConsecutive(nums1));

        // Test Case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}; // Expected: 9 (sequence: [0, 1, 2, 3, 4, 5, 6, 7, 8])
        System.out.println("Test 2 Result: " + longestConsecutive(nums2));

        // Test Case 3
        int[] nums3 = {}; // Expected: 0
        System.out.println("Test 3 Result: " + longestConsecutive(nums3));
    }
}
