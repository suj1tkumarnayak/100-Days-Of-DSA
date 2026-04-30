package day_039_date_2026_05_04.arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArrayBrute(int[] nums){
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i+1; j < n; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    public static int maxSubArray(int[] nums){
        int currSum = nums[0];
        int currMax = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            currSum = Math.max(nums[i], nums[i]+currSum);
            currMax = Math.max(currMax, currSum);
        }

        return currMax;
    }
}
