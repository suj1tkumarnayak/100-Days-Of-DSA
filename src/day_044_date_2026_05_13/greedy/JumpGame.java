package day_044_date_2026_05_13.greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJump(nums));
    }
    private static boolean canJump(int[] nums){
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i>maxReach){
                return false;
            }

            maxReach = Math.max(maxReach, i+nums[i]);

            if(maxReach>=nums.length-1){
                return true;
            }
        }

        return false;
    }
}
