package day_041_date_2026_05_08.bitmanipulation;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 6};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int xor1 = 0, xor2 =0;

        for (int i = 0; i < nums.length; i++) {
            xor1^= nums[i];
        }

        for (int i = 0; i <= nums.length; i++) {
            xor2^=i;
        }

        return xor1^xor2;
    }
}
