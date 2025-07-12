package day_027_date_2025_09_27.leetcode;

import java.util.Arrays;

public class LargestPerimeter {
    public static void main(String[] args) {
        int[] nums = {2,1,2};
        System.out.println(largestPerimeter(nums));
    }

    // n^2
    private static int largestPerimeter(int[] nums) {
        int perimeter = 0;

        Arrays.sort(nums);
        int len = nums.length;

        for (int i = len-1; i >= 0; i--) {
            boolean found = false;
            for (int j = 0; j < i-1; j++) {
                int a = nums[i], b = nums[j], c = nums[j+1];
                if (a < b + c && b < a + c && c < a + b) {
                    perimeter = Math.max(perimeter, a + b + c);
                }
            }

            if(found){
                return perimeter;
            }
        }

        return perimeter;
    }

    // n^3
    public static int largestPerimeter_brute(int[] nums) {
        int perimeter = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int a = nums[i], b = nums[j], c = nums[k];
                    if (a < b + c && b < a + c && c < a + b) {
                        perimeter = Math.max(perimeter, a + b + c);
                    }
                }
            }
        }

        return perimeter;
    }
}
