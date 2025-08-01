package Day_031_Date_2026_04_04.Arrays;

import java.util.Arrays;

public class LeftOrRightRotateByK {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        leftOrRightRotateByK1(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
    private static void leftOrRightRotateByK1(int[] nums, int k) {
        int len = nums.length;
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }
    private static void reverse(int[] nums, int i, int j){
        while (i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    private static void leftOrRightRotateByK2(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            leftRotateByOne(nums);
        }
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
