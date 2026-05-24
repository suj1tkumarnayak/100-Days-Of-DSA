package day_055_date_2026_05_24.round2Questions;

import java.util.Arrays;

public class MinimumOperationsToMakeArrayParityAlternating {

    public static void main(String[] args) {
        MinimumOperationsToMakeArrayParityAlternating solution = new MinimumOperationsToMakeArrayParityAlternating();

        // Example 1
        int[] nums1 = {-2, -3, 1, 4};
        int[] result1 = solution.makeParityAlternating(nums1);
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(result1)); // Expected: [2, 6]
        System.out.println();

        // Example 2
        int[] nums2 = {0, 2, -2};
        int[] result2 = solution.makeParityAlternating(nums2);
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(result2)); // Expected: [1, 3]
    }
    public int[] makeParityAlternating(int[] nums) {

        int[] ans1 = solve(nums, 0); // even odd even odd
        int[] ans2 = solve(nums, 1); // odd even odd even

        if(ans1[0] < ans2[0]) return ans1;

        if(ans2[0] < ans1[0]) return ans2;

        return ans1[1] <= ans2[1] ? ans1 : ans2;
    }

    private int[] solve(int[] nums, int startParity) {

        int ops = 0;

        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {

            int val = nums[i];

            int expectedParity = (startParity + i) % 2;

            int parity = Math.abs(val % 2);

            if(parity != expectedParity) {

                ops++;

                // choose direction minimizing range

                if(val == getMin(nums)) {
                    val++;
                }
                else if(val == getMax(nums)) {
                    val--;
                }
                else {

                    int dec = val - 1;
                    int inc = val + 1;

                    int rangeDec =
                            Math.max(mx, dec) -
                                    Math.min(mn, dec);

                    int rangeInc =
                            Math.max(mx, inc) -
                                    Math.min(mn, inc);

                    if(rangeDec <= rangeInc) {
                        val = dec;
                    } else {
                        val = inc;
                    }
                }
            }

            mn = Math.min(mn, val);
            mx = Math.max(mx, val);
        }

        return new int[]{ops, mx - mn};
    }

    private int getMin(int[] nums) {

        int mn = Integer.MAX_VALUE;

        for(int x : nums) mn = Math.min(mn, x);

        return mn;
    }

    private int getMax(int[] nums) {

        int mx = Integer.MIN_VALUE;

        for(int x : nums) mx = Math.max(mx, x);

        return mx;
    }
//    public int[] makeParityAlternating(int[] nums) {
//        int n = nums.length;
//        if(n==1) return new int[]{0, 0};
//
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        int minOps = 0;
//        int path1 = nums[0]%2;
//        int path2 = nums[1]%2;
//
//        for (int i = 0; i < n-1; i+=2) {
//            if(nums[i]%2!=path1){
//                minOps++;
//                if(nums[i]>0){
//                    nums[i]--;
//                }else{
//                    nums[i]++;
//                }
//            }
//            if(nums[i+1]%2!=path2){
//                minOps++;
//                if(nums[i+1]>0){
//                    nums[i+1]--;
//                }else{
//                    nums[i+1]++;
//                }
//            }
//            min = Math.min(min, nums[i]);
//            min = Math.min(min, nums[i+1]);
//            max = Math.max(max, nums[i]);
//            max = Math.max(max, nums[i+1]);
//        }
//
//        if(n%2==1){
//            if(nums[n-1]%2!=path1){
//                minOps++;
//                if(nums[n-1]>0){
//                    nums[n-1]--;
//                }else{
//                    nums[n-1]++;
//                }
//            }
//            min = Math.min(min, nums[n-1]);
//            max = Math.max(max, nums[n-1]);
//        }
//        return new int[]{minOps, max-min};
//    }
}
