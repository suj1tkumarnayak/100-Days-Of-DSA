package day_051_date_2026_05_20.examquestion;

import java.util.Arrays;

public class LongestSubarrayWithAbsoluteDiff {
    public static void main(String[] args) {
        int[] nums = {2,4,7,2};
        int limit = 5;
        //System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 3)));
        System.out.println(longestSubarray(nums, limit));
    }
    public static int longestSubarray(int[] nums, int limit){
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >=i ; j--) {
                if(sumDifference(Arrays.copyOfRange(nums, i, j+1), limit)){
                    len = Math.max(len, j+1-i);
                }
            }
        }
        return len;
    }
    public static boolean sumDifference(int[] nums, int limit){
        if(nums.length==1) return true;

        for (int i = 0; i < nums.length-1; i++) {
            int diff = Math.abs(nums[i]-nums[i+1]);
            if(diff>limit){
                return false;
            }
        }

        return true;
    }
}
