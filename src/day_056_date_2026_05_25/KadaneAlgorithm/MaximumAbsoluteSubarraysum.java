package day_056_date_2026_05_25.KadaneAlgorithm;

public class MaximumAbsoluteSubarraysum {
    public static void main(String[] args) {
        int[] nums = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsoluteSum(nums));
    }
    public static int maxAbsoluteSum(int[] nums) {
        int currMin = 0;
        int minSum = nums[0];

        int currMax = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            currMin = Math.min(currMin+num, num);
            minSum = Math.min(minSum, currMin);

            currMax = Math.max(currMax+num, num);
            maxSum = Math.max(maxSum, currMax);
        }

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
