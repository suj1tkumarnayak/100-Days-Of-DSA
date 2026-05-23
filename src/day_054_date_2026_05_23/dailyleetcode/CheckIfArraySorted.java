package day_054_date_2026_05_23.dailyleetcode;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?envType=daily-question&envId=2026-05-23
public class CheckIfArraySorted {
    public static void main(String[] args) {
        //            0 1 2 3 4
        int[] nums = {1,2,3};
        System.out.println(check(nums));
    }
    public static boolean check(int[] nums){
        int n = nums.length;
        int index = hillTop(nums);
        System.out.println(index);
        for (int i = 1; i < n; i++) {
            if(nums[(i+index)%n]>nums[(i+index+1)%n]){
                return false;
            }
        }
        return true;
    }
    public static int hillTop(int[] nums){
        int l = 0, h = nums.length-1;

    //    3,4,5,1,2
        while (l<=h){
            int m = l+(h-l)/2;
            // present in the left sorted part
            // it might be hill to hill is present after it
            if(nums[m]>nums[l]){
                l = m;
            }else{
                h = m-1;
            }
        }
        return l;
    }
}
