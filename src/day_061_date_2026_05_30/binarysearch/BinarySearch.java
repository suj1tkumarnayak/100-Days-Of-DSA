package day_061_date_2026_05_30.binarysearch;

import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {
        // Test Case 1: Element exists in the middle
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        // Expected Output: 4

        // Test Case 2: Element does not exist
        int[] nums2 = {-1, 0, 3, 5, 9, 12};
        int target2 = 2;
        // Expected Output: -1

        System.out.println("Test 1 Index (Expected: 4): " + search(nums1, target1));
        System.out.println("Test 2 Index (Expected: -1): " + search(nums2, target2));
    }

    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while (i<=j){
            int m = i+(j-i)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                j = m-1;
            }else{
                i = m+1;
            }
        }
        return -1;
    }
}
