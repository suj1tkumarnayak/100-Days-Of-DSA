package Day_031_Date_2026_04_04.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println(largestNumber(nums));
    }

    private static int largestNumber(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
