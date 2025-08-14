package day_033_date_date_2026_04_10;

public class LargestSubArrayOfSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }
    public static int longestSubarray(int[] arr, int k) {
        int max = 0;
        int sum = 0, len = arr.length;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            if(sum==k){

            }
        }

        return max;
    }
}
