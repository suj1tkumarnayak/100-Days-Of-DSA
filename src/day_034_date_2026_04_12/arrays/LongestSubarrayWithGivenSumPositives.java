package day_034_date_2026_04_12.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubarrayWithGivenSumPositives {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        System.out.println(longestSubArraySlidingWindow(nums, k));
    }

    private static int longestSubArraySlidingWindow(int[] nums, int k) {
        int max = 0, len = nums.length;
        int sum = 0, j = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];

            while(sum>k){
                sum -= nums[j];
                j++;
            }

            if(sum == k){
                max = Math.max(max, i-j+1);
            }
        }

        return max;
    }

    public static int longestSubArray(int[] nums , int k){
        int prefixSum = 0, max = 0, len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            prefixSum += nums[i];

            if(prefixSum==k){
                max = Math.max(max, i+1);
            }

            int complement = prefixSum - k;

            if(map.containsKey(complement)){
                max = Math.max(max, i - map.get(complement));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }

        return max;
    }
}
