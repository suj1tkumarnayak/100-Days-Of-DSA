package day_035_date_2026_04_13.arrays;

public class MinimumDistanceToTheTargetElement {
    public static void main(String[] args) {
        int[] nums = { 1, 1 ,1, 1,1,1,1 };
        int target = 1;
        int start = 0;
        System.out.println(getMinDistance(nums, target, start));
    }
    public static int getMinDistance(int[] nums, int target, int start) {
        int len = nums.length, minDist = len;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if(num == target){
                minDist = Math.min(minDist, Math.abs(i-start));
            }
        }

        return minDist;
    }
}
