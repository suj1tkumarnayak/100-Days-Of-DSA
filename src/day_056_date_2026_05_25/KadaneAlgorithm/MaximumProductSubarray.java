package day_056_date_2026_05_25.KadaneAlgorithm;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {

        int n = nums.length;

        int maxEnding = nums[0];
        int minEnding = nums[0];

        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int tempMin = Math.min(num, Math.min(minEnding*num, maxEnding*num));
            int tempMax = Math.max(num, Math.max(minEnding*num, maxEnding*num));

            maxEnding = tempMax;
            minEnding = tempMin;

            ans = Math.max(ans, maxEnding);
        }

        return ans;
    }
}
