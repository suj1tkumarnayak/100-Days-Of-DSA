package day_080_date_2026_06_25.dailyproblem;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithMajorityElementI {

    public static void main(String[] args) {
        CountSubarraysWithMajorityElementI solver = new CountSubarraysWithMajorityElementI();

        // Test Case 1: Target mixed with other numbers
        int[] nums1 = {1, 2, 2, 3};
        int target1 = 2;
        System.out.println("Test 1 - Expected: 5");
        System.out.println("Brute Force: " + solver.countMajoritySubarraysBruteForce(nums1, target1));
        System.out.println("Better (O(n^2)): " + solver.countMajoritySubarraysBetter(nums1, target1));
        System.out.println("Optimal (Prefix): " + solver.countMajoritySubarraysOptimal(nums1, target1));
        System.out.println("--------------------------------------------------");

        // Test Case 2: All elements are the target element
        int[] nums2 = {1, 1, 1, 1};
        int target2 = 1;
        System.out.println("Test 2 - Expected: 10");
        System.out.println("Brute Force: " + solver.countMajoritySubarraysBruteForce(nums2, target2));
        System.out.println("Better (O(n^2)): " + solver.countMajoritySubarraysBetter(nums2, target2));
        System.out.println("Optimal (Prefix): " + solver.countMajoritySubarraysOptimal(nums2, target2));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Target element does not exist in the array
        int[] nums3 = {1, 2, 3};
        int target3 = 4;
        System.out.println("Test 3 - Expected: 0");
        System.out.println("Brute Force: " + solver.countMajoritySubarraysBruteForce(nums3, target3));
        System.out.println("Better (O(n^2)): " + solver.countMajoritySubarraysBetter(nums3, target3));
        System.out.println("Optimal (Prefix): " + solver.countMajoritySubarraysOptimal(nums3, target3));
    }

    /**
     * Approach 1: Brute Force
     * Hint: Use three nested loops. Two loops to mark the boundaries of every
     * single subarray (i to j), and a third loop to count the occurrences of
     * target within that frame to see if it crosses the floor(len / 2) threshold.
     * * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public int countMajoritySubarraysBruteForce(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        // outer loop for lower boundary or first element of the subarray
        for (int i = 0; i < n; i++) {
            // inner loop for the upper boundary or last element of the subarray
            for (int j = i; j < n; j++) {
                int majorityCount = 0;
                for (int k = i; k <= j ; k++) {
                    if(nums[k]==target){
                        majorityCount++;
                    }
                }

                if(majorityCount>(j-i+1)/2){
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Approach 2: Better (Optimized Enumerate)
     * Hint: Instead of recounting the target frequency from scratch using a third loop,
     * maintain a running `targetCount` counter as you expand the right boundary 'j'
     * of your subarray from starting point 'i'.
     * * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int countMajoritySubarraysBetter(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        // outer loop for lower boundary or first element of the subarray
        for (int i = 0; i < n; i++) {
            // inner loop for the upper boundary or last element of the subarray
            int targetCount = 0;
            for (int j = i; j < n; j++) {

                if(nums[j]==target){
                    targetCount++;
                }

                if(targetCount>(j-i+1)/2){
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Approach 3: Optimal (Prefix Difference Transformation)
     * Hint: Map every element equal to target as +1, and all others as -1.
     * Target becomes the strict majority if and only if the sum of the subarray is > 0.
     * Use a prefix sum tracking array/BIT map to quickly find how many previous
     * prefix values are strictly smaller than the current running sum.
     * * Time Complexity: O(n log n) or O(n)
     * Space Complexity: O(n)
     */
    public int countMajoritySubarraysOptimal(int[] nums, int target) {
        int n = nums.length;

        // mapping the target as 1 and non target as -1
        int[] bitMap = new int[n];

        for (int i = 0; i < n; i++) {
            if(nums[i]==target){
                bitMap[i] = 1;
            }else{
                bitMap[i] = -1;
            }
        }
        
        // find the prefix sum of the bit map..
        // if the current index is 1 or more then that mean target was the majority
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = bitMap[i-1]+prefixSum[i-1];
        }

        return 0;
    }

}