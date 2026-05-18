package day_049_date_2026_05_18.sheet.arrays;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m+n];
        for (int i = 0; i < m; i++) {
            merged[i] = nums1[i];
        }
        for (int i = 0; i < n; i++) {
            merged[i+m] = nums2[i];
        }
        Arrays.sort(merged);
        System.out.println(Arrays.toString(merged));
        double median = (merged[(m+n)/2]+merged[((m+n)/2)-1])/2;

        return median;
    }
}
