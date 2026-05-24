package day_055_date_2026_05_24.bitmanipulation;

public class MaximumXOROfTwoNumberInAArray {
    // time complexity is n^2
    public static int findMaximumXOR(int[] nums) {
        // TODO: Implement the maximum XOR logic here
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int xor = nums[i]^nums[j];
                max = Math.max(xor, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {3, 10, 5, 25, 2, 8}; // Expected: 28
        int[] nums2 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}; // Expected: 127

        System.out.println("Test 1 Result: " + findMaximumXOR(nums1));
        System.out.println("Test 2 Result: " + findMaximumXOR(nums2));
    }
}
