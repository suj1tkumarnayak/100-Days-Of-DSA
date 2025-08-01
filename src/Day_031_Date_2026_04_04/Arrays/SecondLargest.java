package Day_031_Date_2026_04_04.Arrays;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println(Arrays.toString(secondLargest2(nums)));
    }

    private static int[] secondLargest2(int[] nums) {
        int larger = Integer.MIN_VALUE;
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        int smaller = Integer.MAX_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if(num>larger){
                large = larger;
                larger = num;
            }else if(num>large && num!=larger){
                large = num;
            }

            if(num<smaller){
                small = smaller;
                smaller = num;
            }else if(num<small && num!=smaller){
                small = num;
            }
        }

        return new int[]{small, large};
    }

    public static int secondLargest1(int[] nums){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            largest = Math.max(largest, nums[i]);
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if(num>secondLargest && num<largest){
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
