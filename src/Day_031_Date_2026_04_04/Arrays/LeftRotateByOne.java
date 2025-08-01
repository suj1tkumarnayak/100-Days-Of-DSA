package Day_031_Date_2026_04_04.Arrays;

import java.util.Arrays;

public class LeftRotateByOne {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        leftRotateByOne(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void leftRotateByOne(int[] nums) {
        int len = nums.length;

        if(len == 0 || len ==1){
            return;
        }
        int first = nums[0];

        for (int i = 1; i < len; i++) {
            nums[i-1] = nums[i];
        }

        nums[len-1] = first;
    }
}
