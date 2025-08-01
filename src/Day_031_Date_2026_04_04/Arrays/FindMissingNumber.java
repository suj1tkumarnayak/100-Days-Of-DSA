package Day_031_Date_2026_04_04.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 5, 3, 7, 1, 9, 10, 6, 12};
        System.out.println(findMissingNumber(nums));
    }

    private static int findMissingNumber(int[] nums) {
        int sum = 0, len = nums.length+1;

        for(int num: nums){
            sum += num;
        }

        return (len*(len+1)/2)-sum;
    }
}
