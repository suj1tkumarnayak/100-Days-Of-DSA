package day_063_date_2026_06_01.backtracking;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 59;
        System.out.println(binarySearch(nums, target));
    }
    public static int binarySearch(int[] nums, int target){
        int l = 0, h = nums.length-1;
        return helper(nums, target, l, h);
    }
    public static int helper(int[] nums, int target, int l, int h){
        if(l>h){
            return -1;
        }
        int m = l+(h-l)/2;

        if(nums[m]==target) return m;
        else if(nums[m]>target) return helper(nums, target, l, m-1);
        else return helper(nums, target, m+1, h);
    }
}
