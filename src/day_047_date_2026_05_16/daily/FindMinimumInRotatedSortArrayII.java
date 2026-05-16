package day_047_date_2026_05_16.daily;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/?envType=daily-question&envId=2026-05-16

public class FindMinimumInRotatedSortArrayII {
    public static void main(String[] args) {
        int[] nums ={10,1,10,10,10}; //{4,5,6,7,0,1,4}; // {2,2,2,0,1};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        int l = 0, h = nums.length-1;
        int min = Integer.MAX_VALUE;
        // 0, 1, 2, 3, 4, 5, 6
//        {4, 5, 6, 7, 0, 1, 4}
        while (l<=h){
            int m = l+(h-l)/2;
            if(nums[l]<=nums[m]){
                min = Math.min(min, nums[l]);
                l = m+1;
            }else{
                min = Math.min(min, nums[m]);
                h = m-1;
            }
        }
        return min;
    }
}
