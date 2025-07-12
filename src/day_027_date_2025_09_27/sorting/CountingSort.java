package day_027_date_2025_09_27.sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = { 4, 2, 2, 8, 3, 3, 1 };
        countingSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void countingSort(int[] nums){
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;

        // find the min and max
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int range = max-min+1;

        int[] count = new int[range];

        // find the frequency of the nums
        for (int num: nums){
            count[num-min]++;
        }

        //calculate the cumulative frequency for the position
        for (int i = 1; i < len; i++) {
            count[i] += count[i-1];
        }

        //find and the numbers in the position
        int[] output = new int[len];
        for (int i = len-1; i >= 0; i--) {
            int num = nums[i];
            output[count[num-min]-1] = num;
            count[num-min]--;
        }

        //copy back
        System.arraycopy(output, 0, nums, 0, len);
    }
}
