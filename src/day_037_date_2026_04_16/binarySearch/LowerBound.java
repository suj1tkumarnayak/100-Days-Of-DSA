package day_037_date_2026_04_16.binarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = { 0,1,2,2,2,3 };
        System.out.println(lowerBound(nums, 2));
    }
    public static int lowerBound(int[] nums, int target){
        int l = 0, h = nums.length;
        int ans = -1;
        while (l<=h){
            int mid = l+(h-l)/2;
            if(nums[mid]>=target){
                ans = mid;
                h = mid - 1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
