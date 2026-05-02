package day_039_date_2026_05_04.arrays;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        if(n==1) return min;
        int l = 0, h = nums.length-1;

        while(l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]<nums[l]){
                if(nums[mid]<min){
                    min = nums[mid];
                }
                h = mid-1;
            }else{
            }
        }
        return 1;
    }

    public static int findMinBrute(int[] nums){
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            min = Math.min(min, num);
        }

        return min;
    }
}
