package day_040_date_2026_05_07.bitmanupulation;

public class FindTheUniqueNumber {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,2,3,4};
        System.out.println(findTheUniqueNumber(nums));
    }
    public static int findTheUniqueNumber(int[] nums){
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
