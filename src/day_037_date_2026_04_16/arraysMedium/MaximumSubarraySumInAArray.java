package day_037_date_2026_04_16.arraysMedium;

import java.util.HashMap;

public class MaximumSubarraySumInAArray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArraybrute(nums));
    }

    private static int maxSubArraybrute(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            max = Math.max(sum, max);
            for (int j = i+1; j < nums.length; j++) {
                sum+= nums[j];
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public static int maxSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            
        }
        return -1;
    }
}
