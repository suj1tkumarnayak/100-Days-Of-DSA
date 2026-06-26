package day_080_date_2026_06_25.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement solver = new MajorityElement();

        // Test Case 1: Majority element is 3
        int[] nums1 = {3, 2, 3};
        System.out.println("Test 1 - Expected: 3");
        System.out.println("Sorting: " + solver.majorityElementSorting(nums1.clone()));
        System.out.println("HashMap: " + solver.majorityElementHashMap(nums1.clone()));
        System.out.println("Optimal (Boyer-Moore): " + solver.majorityElementOptimal(nums1.clone()));
        System.out.println("--------------------------------------------------");

        // Test Case 2: Majority element is 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Test 2 - Expected: 2");
        System.out.println("Sorting: " + solver.majorityElementSorting(nums2.clone()));
        System.out.println("HashMap: " + solver.majorityElementHashMap(nums2.clone()));
        System.out.println("Optimal (Boyer-Moore): " + solver.majorityElementOptimal(nums2.clone()));
        System.out.println("--------------------------------------------------");

        // Test Case 3: Single element array
        int[] nums3 = {5};
        System.out.println("Test 3 - Expected: 5");
        System.out.println("Sorting: " + solver.majorityElementSorting(nums3.clone()));
        System.out.println("HashMap: " + solver.majorityElementHashMap(nums3.clone()));
        System.out.println("Optimal (Boyer-Moore): " + solver.majorityElementOptimal(nums3.clone()));

        // Test Case 3: Single element array
        int[] nums4 = {1,1,1,2,2,2,1};
        System.out.println("Test 4 - Expected: 1");
        System.out.println("Sorting: " + solver.majorityElementSorting(nums4.clone()));
        System.out.println("HashMap: " + solver.majorityElementHashMap(nums4.clone()));
        System.out.println("Optimal (Boyer-Moore): " + solver.majorityElementOptimal(nums4.clone()));
    }

    /**
     * Approach 1: Better (Sorting)
     * Hint: If an element appears more than ⌊n / 2⌋ times, it will *always* * occupy the middle index of the array once it is sorted.
     * * Time Complexity: O(n log n)
     * Space Complexity: O(1) or O(n) depending on the sorting algorithm implementation
     */
    public int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return nums[n/2];
    }

    /**
     * Approach 2: Better (HashMap)
     * Hint: Build a frequency map tracking the count of each number.
     * Loop through the map and return the key whose value is greater than ⌊n / 2⌋.
     * * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if(entry.getValue()>nums.length/2) return entry.getKey();
        }

        return -1;
    }

    /**
     * Approach 3: Optimal (Boyer-Moore Voting Algorithm)
     * Hint: Maintain a `candidate` and a `count`. Iterate through the array.
     * If `count == 0`, pick the current element as the new candidate.
     * If the current element matches the candidate, increment `count`; otherwise, decrement it.
     * * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int majorityElementOptimal(int[] nums) {
        int candidate = nums[0];

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if(count==0){
                candidate = nums[i];
                count = 1;
            }else if(nums[i]==candidate){
                count++;
            }else{
                count--;
            }
        }


        return candidate;
    }
}