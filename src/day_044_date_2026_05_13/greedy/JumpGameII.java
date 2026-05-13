package day_044_date_2026_05_13.greedy;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJumpRecursion(nums,0));
    }
    private static int canJump(int[] nums){
        int dp[] = new int[nums.length];

        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                //dp[i] = dp[i]+Math.min(dp)
            }
        }

        return dp[nums.length-1];
    }
    private static int canJumpRecursion(int[] nums, int index){
        if(index>=nums.length-1) return 0;

        int minJump = Integer.MAX_VALUE;

        for (int jump = 1; jump <= nums[index]; jump++) {
            int nextJump = index+jump;

            int result = canJumpRecursion(nums, nextJump);

            if(result!=Integer.MAX_VALUE){
                minJump = Math.min(minJump, 1+result);
            }
        }

        return minJump;
    }
}
