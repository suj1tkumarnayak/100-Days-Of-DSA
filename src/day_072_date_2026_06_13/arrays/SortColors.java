package day_072_date_2026_06_13.arrays;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    // DNF method (Dutch National Flag method)
    // Basic idea divide the number in four groups (0's, 1's, unknown, 2's)
    // for the above we would need three pointers

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, m = 0, h = n-1;

        while (m<=h){
            if(nums[m]==0){
                swap(nums, l, m);
                l++;
            }else if(nums[m]==2){
                swap(nums, h, m);
                h--;
            }else{
                m++;
            }
            if(l>m){
                m++;
            }
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void bruteForce(int[] nums) {
        Arrays.sort(nums);
    }

    public static void betterApproach(int[] nums) {
        int n = nums.length;
        int[] count = new int[3];

        for (int num : nums) {
            count[num]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]>0){
                nums[k] = i;
                count[i]--;
                k++;
            }
        }
    }
}
