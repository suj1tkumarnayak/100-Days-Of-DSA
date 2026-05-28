package day_060_date_2026_05_29.dailyleetcode;

public class MinimumElementAfterReplacementWithDigitSum {
    public static void main(String[] args) {
        int[] nums = {10,12,13,14};
        System.out.println(minElement(nums));
    }
    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int currSum = digitSum(num);
            min = Math.min(currSum, min);
        }

        return min;
    }
    public static int digitSum(int num){
        int sum = 0;

        while (num>0){
            sum+= num%10;
            num/=10;
        }

        return sum;
    }
}
