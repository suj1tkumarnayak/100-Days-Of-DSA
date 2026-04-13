package day_035_date_2026_04_13.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSumbrute(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int sum = nums[i]+nums[j];
                if( sum == target){
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{ -1, -1 };
    }
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
