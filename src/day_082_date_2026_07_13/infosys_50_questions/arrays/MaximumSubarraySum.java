package day_082_date_2026_07_13.infosys_50_questions.arrays;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        MaximumSubarraySum solver = new MaximumSubarraySum();

        // --- TEST CASE 1 ---
        // Mixed positive and negative numbers.
        // The optimal subarray is [4, -1, 2, 1] which has the largest sum = 6.
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test Case 1: " + solver.maxSubArrayKadane(nums1) + " (Expected: 6)");

        // --- TEST CASE 2 ---
        // Single element array.
        // Expected Output: 1
        int[] nums2 = {1};
        System.out.println("Test Case 2: " + solver.maxSubArrayDivideAndConquer(nums2) + " (Expected: 1)");

        // --- TEST CASE 3 ---
        // All negative numbers.
        // The largest sum is just the maximum single element [-1].
        // Expected Output: -1
        int[] nums3 = {-2, -3, -1, -5};
        System.out.println("Test Case 3: " + solver.maxSubArrayBruteForce(nums3) + " (Expected: -1)");
    }

    /**
     * Approach 1: Brute Force [Naive]
     * Strategy: Check all possible subarrays. Use two nested loops to define the
     * start and end boundaries of the subarray, and keep track of the maximum sum found.
     * Time Complexity: $O(n^2)$
     * Space Complexity: $O(1)$
     */
    public int maxSubArrayBruteForce(int[] nums){
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
    // this is n^3 time complexity solution
//    public int maxSubArrayBruteForce(int[] nums) {
//        int maxSum = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int currSum = 0;
//                for (int k = i; k <= j; k++) {
//                    currSum+= nums[k];
//                }
//                maxSum = Math.max(maxSum, currSum);
//            }
//        }
//        return maxSum;
//    }


    /**
     * Approach 2: Divide and Conquer [Algorithmic Classic]
     * Strategy: Split the array into two halves. The maximum subarray sum can either be:
     * 1. Entirely in the left half.
     * 2. Entirely in the right half.
     * 3. Crossing the midpoint.
     * Time Complexity: $O(n \log n)$
     * Space Complexity: $O(\log n)$ due to recursion stack
     */
    public int maxSubArrayDivideAndConquer(int[] nums) {
        return 0;
    }

    /**
     * Approach 3: Kadane's Algorithm [Most Optimized / Linear Time]
     * Strategy: Dynamic Programming concept. Track the local maximum subarray sum ending
     * at the current position, and the global maximum found so far. At each element,
     * decide whether to add it to the current subarray or start a new subarray from it.
     * Time Complexity: $O(n)$
     * Space Complexity: $O(1)$
     */
    public int maxSubArrayKadane(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}