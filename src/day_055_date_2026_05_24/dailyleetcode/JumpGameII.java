package day_055_date_2026_05_24.dailyleetcode;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4};
        System.out.println(jumpBrute(nums));
    }
    public static int jumpRecursion(int[] nums){
        return helper(nums, 0, 0);
    }
    public static int helper(int[] nums, int i, int maxReach){
        if(i>=nums.length) return 0;
        if(maxReach == nums.length-1) return 1;
        int jumps = Integer.MAX_VALUE;
        int reach = maxReach;

        for (int j = i; j < reach; j++) {
            maxReach = Math.max(maxReach, nums[j]+j);
            jumps = Math.min(jumps, 1+helper(nums, j, maxReach));
        }

        return jumps;
    }
    public static int jumpBrute(int[] nums) {
        int n = nums.length;
        int count = Integer.MAX_VALUE;

        int maxLen = 0;


        for (int i = 0; i < n; i++) {

        }

        return count;
    }
}
