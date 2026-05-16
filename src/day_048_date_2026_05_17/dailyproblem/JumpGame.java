package day_048_date_2026_05_17.dailyproblem;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int maxReach = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i>maxReach){
                return false;
            }
            maxReach= Math.max(maxReach, i+nums[i]);
            if(maxReach==n-1) return true;
        }

        return true;
    }
}
