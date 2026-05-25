package day_056_date_2026_05_25.KadaneAlgorithm;

public class CircularSubarraySum {
    public static void main(String[] args) {
        int nums[] = {5,-3,5};
        CircularSubarraySum solution = new CircularSubarraySum();
        System.out.println(solution.maxSubarraySumCircular(nums));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int currMin = 0;
        int minSum = nums[0];

        int currMax = 0;
        int maxSum = nums[0];

        for (int num : nums) {
            totalSum += num;

            currMax = Math.max(currMax+num, num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin+num, num);
            minSum = Math.min(currMin, minSum);
        }

        if(maxSum<0){
            return maxSum;
        }

        return Math.max(totalSum-minSum, maxSum);
    }
}
