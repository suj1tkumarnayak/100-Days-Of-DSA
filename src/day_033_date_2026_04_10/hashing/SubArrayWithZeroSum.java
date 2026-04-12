package day_033_date_2026_04_10.hashing;

import java.util.HashSet;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = { 4, 2, -3, 1, 6 };
        System.out.println(findSum(arr));
    }
    public static boolean findSumBrute(int[] arr){
        int len = arr.length, sum;
        for (int i = 0; i < len; i++) {
            sum = arr[i];
            if(sum == 0){
                return true;
            }
            for (int j = i+1; j < len; j++) {
                sum += arr[j];
                if(sum == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean findSum(int[] arr){
        int len = arr.length, sum = 0 ;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            sum += arr[i];

            if(set.contains(sum) || sum == 0){
                return true;
            }
            set.add(sum);
        }

        return false;
    }
}
