package Day_031_Date_2026_04_04.Arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = {1,1,2,2,2,3,3};
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums){
        int k = 0, len = nums.length;
        for (int i = 1; i < len; i++) {
            if(nums[i]!=nums[k]){
                k++;
                nums[k] = nums[i];

            }
        }
        //nums[k] = nums[len-1];
        return k+1;
    }
}
