package day_063_date_2026_06_01.backtracking;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 5;
        System.out.println(linearSearch(nums, target));
    }
    public static int linearSearch(int[] nums, int target){
        return helper(nums, target, 0);
    }
    public static int helper(int[] nums, int target, int i){
        if(i>=nums.length){
            return -1;
        }
        if(nums[i]==target) return i;
        return helper(nums, target, i+1);
    }
}
