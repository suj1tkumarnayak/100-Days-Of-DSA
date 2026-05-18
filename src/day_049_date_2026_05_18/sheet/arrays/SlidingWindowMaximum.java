package day_049_date_2026_05_18.sheet.arrays;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        //            0,1, 2, 3,4,5,6,7
        int[] nums = {1,3,1,2,0,5};
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n-k+1];
        int resInd = 0;

        for (int i = 0; i < n; i++) {
            if(!dq.isEmpty() && dq.peek()<=i-k){
                dq.pollFirst();
            }

            while (!dq.isEmpty() && nums[dq.getLast()]<nums[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i>=k-1){
                result[resInd++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
