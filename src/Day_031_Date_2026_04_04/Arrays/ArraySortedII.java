package Day_031_Date_2026_04_04.Arrays;

public class ArraySortedII {
    public static void main(String[] args) {
        int[] nums = {1,2,7,3,4,5};
        System.out.println(arraySorted(nums));
    }

    private static boolean arraySorted(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }
}
