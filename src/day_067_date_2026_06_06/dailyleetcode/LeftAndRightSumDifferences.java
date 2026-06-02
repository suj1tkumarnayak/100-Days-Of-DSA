package day_067_date_2026_06_06.dailyleetcode;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        int[] nums = { 10, 4, 8, 3 };
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
    public static int[] leftRightDifference1(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i-1]+nums[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            rightSum[i] = rightSum[i+1]+nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(leftSum[i]-rightSum[i]);
        }
        return nums;
    }
    public static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            ans[i] = leftSum;
            leftSum+= nums[i];
        }
        int rightSum = 0;
        for (int i = n-1; i >=0 ; i--) {
            int val = Math.abs(ans[i]-rightSum);
            rightSum+=nums[i];
            ans[i] = val;
        }
        return ans;
    }
}
