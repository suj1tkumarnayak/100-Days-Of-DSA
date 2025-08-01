package Day_031_Date_2026_04_04.Arrays;

public class FindTheUniqueNum {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2};
        System.out.println(findTheUniqueNum(nums));
    }

    private static int findTheUniqueNum(int[] nums) {
        int len = nums.length, ans = 0;
        if(len == 1){
            return nums[0];
        }
        ans = nums[0];

        for (int i = 1; i < len; i++) {
                ans ^= nums[i];
        }

        return ans;
    }
}
