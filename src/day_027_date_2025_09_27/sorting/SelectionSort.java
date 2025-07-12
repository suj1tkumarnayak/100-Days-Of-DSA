package day_027_date_2025_09_27.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        selectionSort_largeFirst(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort_largeFirst(int[] nums) {
        int len = nums.length;

        for (int i = len-1; i > 0 ; i--) {
            int maxInd = i;

            for (int j = 0; j < i; j++) {
                if(nums[j]>nums[maxInd]){
                    maxInd = j;
                }
            }

            swap( nums, i, maxInd);
        }
    }

    public static void selectionSort_smallFirst(int[] nums){
        int len = nums.length;

        for (int i = 0; i < len-1; i++) {
            int minInd = i;
            for (int j = i+1; j < len; j++) {
                if(nums[j]<nums[minInd]){
                    minInd = j;
                }
            }
            swap(nums, i, minInd);
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
