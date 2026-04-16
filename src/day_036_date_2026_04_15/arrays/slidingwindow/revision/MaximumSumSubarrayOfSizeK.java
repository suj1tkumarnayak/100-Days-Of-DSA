package day_036_date_2026_04_15.arrays.slidingwindow.revision;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {100, 200, 300, 400};
        System.out.println(maximumSum(nums, 3));
    }
    public static int maximumSum(int[] nums, int k){
        int max = 0, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = Math.max(max, sum);

        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
