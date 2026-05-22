package day_053_date_2026_05_22.arrays;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
//        for (int i = 0; i < n; i++) {
//            int num = nums[i];
//            for (int j = 0; j < n; j++) {
//                if(i!=j && nums[j]==)
//            }
//        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i]==nums[i-1]+1){
                count++;
            }else if(nums[i]==nums[i-1]){
                continue;
            }else{
                count=1;
            }
            maxLen = Math.max(count, maxLen);
        }
        return maxLen;
    }
}
