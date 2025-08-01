package Day_031_Date_2026_04_04.Arrays;

public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1,1,1,0,1 };
        System.out.println(maximumConsecutiveOnes(nums));
    }

    private static int maximumConsecutiveOnes(int[] nums) {
        int max = 0, len = nums.length;

        for (int i = 0; i < len; i++) {
            int count = 0;
            int j = i;
            while( j<len && i<len && nums[j]==1 ){
                count++;
                j++;
                i++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
