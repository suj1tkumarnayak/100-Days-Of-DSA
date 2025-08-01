package Day_031_Date_2026_04_04.Arrays;

import java.util.Arrays;

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        int[] nums = { 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1 };
        moveZeroesToEnd(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroesToEnd(int[] nums) {
        int len = nums.length;
        if ( len == 0 || len == 1){
            return;
        }
        int i = 0, j = 0;
        while (j<len && i<len){
            while (i<len && nums[i]!=0){
                i++;
            }
            while (j<len && nums[j]==0){
                j++;
            }
            if(i<len && j<len){
                swap(nums, i, j);
            }
            i++;
            j--;
        }
    }

    private static void moveZeroesToEnd_NoOrder(int[] nums) {
        int i = 0, j = nums.length-1;
        while (i<j){
            while(nums[j]==0 && j>i){
                j--;
            }
            while (nums[i]!=0 && i<j){
                i++;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
