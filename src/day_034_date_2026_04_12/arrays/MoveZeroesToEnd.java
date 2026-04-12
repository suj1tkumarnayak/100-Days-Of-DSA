package day_034_date_2026_04_12.arrays;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int i = 0, j = 0, len = nums.length;

        while (true) {
            // find next non-zero
            while (i < len && nums[i] == 0) {
                i++;
            }

            // find next zero
            while (j < len && nums[j] != 0) {
                j++;
            }

            // stop if either pointer goes out
            if (i >= len || j >= len) break;

            // swap only if zero is before non-zero
            if (j < i) {
                swap(nums, i, j);
            } else {
                // if j >= i, move i forward to find next valid non-zero
                i++;
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
