package day_055_date_2026_05_24.dailyleetcode;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;

        for (int i = 0; i < n; i++) {
            if(i>maxReach){
                return false;
            }

            maxReach = Math.max(maxReach, nums[i]+i);

            if(maxReach==n-1){
                return true;
            }
        }

        return true;
    }
}
