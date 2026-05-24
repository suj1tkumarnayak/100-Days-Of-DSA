package day_055_date_2026_05_24.dailyleetcode;

import java.util.Arrays;

public class JumpGameIX {
    public static void main(String[] args) {
        int nums[] = {2,1,3};
        System.out.println(Arrays.toString(maxValue(nums)));
    }
    public static int[] maxValue(int[] nums){
        return helper(nums, 0);
    }
    public static int[] helper(int[] nums, int i) {
        if(i<0 || i>=nums.length) return nums;
        // check left if there is nums[j] which is greater that nums[i]
        // check right if there is nums[j] which is less than nums[i];
        return nums;
    }
}
