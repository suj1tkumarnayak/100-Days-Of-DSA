package day_049_date_2026_05_18.sheet.dynamicprogramming;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2!=0) return false;

        return backtrack(nums, 0, sum/2);
    }
    private static boolean backtrack(int[] nums, int index, int target){
        if(target==0) return true;

        if(target<0 || index>=nums.length) return false;

        return backtrack(nums, index+1, target-nums[index]) || backtrack(nums, index+1, target);
    }
}
