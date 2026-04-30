package day_039_date_2026_05_04.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExcept(nums)));
    }
    public static int[] productExcept(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        //after finishing this {1, 1, 2, 3}
        suffix[n-1] = 1;
        for (int i = n-2; i >=0 ; i--) {
            suffix[i] = suffix[i+1]*nums[i+1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = prefix[i]*suffix[i];
        }
        return nums;
    }
}
