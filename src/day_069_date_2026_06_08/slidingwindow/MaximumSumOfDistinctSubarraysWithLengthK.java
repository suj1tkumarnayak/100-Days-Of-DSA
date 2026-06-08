package day_069_date_2026_06_08.slidingwindow;

import java.util.*;

public class MaximumSumOfDistinctSubarraysWithLengthK {

    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        int n = nums.length;

        // Use a Map to count how many times a number is in our window
        Map<Integer, Integer> counts = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            // Add the incoming element
            int rightNum = nums[windowEnd];
            currentSum += rightNum;
            counts.put(rightNum, counts.getOrDefault(rightNum, 0)+1);

            // If the window grows larger than the k, shrink from the left
            if(windowEnd-windowStart+1>k){
                int leftNum = nums[windowStart];
                currentSum -= leftNum;

                // Reduce the count of the leftNum or remove from the map if drops to 0;
                if(counts.get(leftNum)==1){
                    counts.remove(leftNum);
                }else{
                    counts.put(leftNum, counts.get(leftNum)-1);
                }
                windowStart++;
            }

            // If the counts size is exactly k then there are k unique elements
            if(windowEnd-windowStart+1==k && counts.size()==k){
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumOfDistinctSubarraysWithLengthK solver = new MaximumSumOfDistinctSubarraysWithLengthK();

        // Test Case 1
        int[] nums1 = {1, 5, 4, 2, 9, 9, 9};
        int k1 = 3;
        System.out.println("Test 1 - Expected: 15, Actual: " + solver.maximumSubarraySum(nums1, k1));

        // Test Case 2
        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        System.out.println("Test 2 - Expected: 0, Actual: " + solver.maximumSubarraySum(nums2, k2));
    }
}
