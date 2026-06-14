package day_072_date_2026_06_13.infosys_50_questions.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int indx = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while(!dq.isEmpty() && dq.peekFirst()<=(i-k)){
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);

            if(i>=k-1){
                res[indx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
    public static int[] bruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        for (int i = 0; i < n-k; i++) {
            int max = nums[i];

            for (int j = i; j < i+k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }

        return res;
    }
}
