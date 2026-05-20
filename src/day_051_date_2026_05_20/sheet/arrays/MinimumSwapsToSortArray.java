package day_051_date_2026_05_20.sheet.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapsToSortArray {
    public static void main(String[] args) {
        int[] arr = {2, 8, 5, 4};
        System.out.println(minSwapsBrute(arr));
    }
    public static int minSwapsHashmap(int arr[]){
        int swaps = 0;

        int[] sorted = arr.clone();
        Arrays.toString(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=sorted[i] && map.containsKey(sorted[i])){
//                arr[i] =
            }
        }

        return swaps;
    }
    public static int minSwapsBrute(int arr[]) {
        // Code here
        int swap = 0;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=sorted[i]){
                int j = i+1;
                while(j < arr.length && arr[j]!=sorted[i]){
                    j++;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                swap++;
            }
        }
        return swap;
    }
}
