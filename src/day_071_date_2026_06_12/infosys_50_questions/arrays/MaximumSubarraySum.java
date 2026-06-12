package day_071_date_2026_06_12.infosys_50_questions.arrays;

public class MaximumSubarraySum {

    // Write your logic inside this method
    public static void printMaxSubArray(int[] nums) {
        // handle empty array edge case
        if(nums==null || nums.length==0){
            System.out.println("Array is empty");
            return;
        }

        int n = nums.length;
        int maxSum = nums[0];
        int currSum = nums[0];

        int startIndex = 0;
        int endIndex = 0;
        int tempStartIndex = 0;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            currSum += num;
            if(currSum<num){
                tempStartIndex = i;
                currSum = num;
            }

            if(currSum>=maxSum){
                startIndex = tempStartIndex;
                endIndex = i;
                maxSum = currSum;
            }
        }

        // This prints the final results
        System.out.println("Maximum Sum: " + maxSum);
        System.out.print("Subarray elements: ");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nIndices: From index " + startIndex + " to " + endIndex);
    }

    public static void main(String[] args) {
        // Test case 1: Standard mix of numbers
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("--- Test 1 ---");
        printMaxSubArray(test1); // Expected: Sum 6, Subarray [4, -1, 2, 1], Indices 3 to 6

        // Test case 2: All negative numbers
        int[] test2 = {-5, -1, -8, -2};
        System.out.println("\n--- Test 2 ---");
        printMaxSubArray(test2); // Expected: Sum -1, Subarray [-1], Indices 1 to 1
    }
}
