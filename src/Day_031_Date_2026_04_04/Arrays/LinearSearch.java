package Day_031_Date_2026_04_04.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(findElement(nums, 4));
    }
    public static int findElement(int[] nums, int target){
        int k = -1, len = nums.length;

        for (int i = 0; i < len; i++) {
            if(nums[i] == target){
                return i;
            }
        }

        return k;
    }
}
