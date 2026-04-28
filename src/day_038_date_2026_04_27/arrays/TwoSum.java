package day_038_date_2026_04_27.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15, 1 };
        System.out.println(Arrays.toString(towSumOptimal(nums, 3)));
    }
    public static int[] twoSumBrute(int[] nums, int target){
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(target-nums[j] == nums[i] ){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
    public static int[] twoSumBetter(int[] nums, int target){
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int complement = target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
    public static int[] towSumOptimal(int[] nums, int target){
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while(i<j){
            //int mid = i+(j-i)/2;
            int sum = nums[i]+nums[j];
            if(sum == target){
                return new int[]{i, j};
            }else if(sum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{-1, -1};
    }
}
