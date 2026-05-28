package day_059_date_2026_05_28.infosys_50_questions;

import java.util.HashMap;

public class SubarrayRangeWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 10, 2, -2, -20, 10 };
        int target = -10;
        System.out.println(subArraySum(arr, target));
    }
    public static int subArraySum(int arr[], int tar) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs once initially
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            int need = prefixSum - tar;
            if(map.containsKey(need)){
                count += map.get(need);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }

        return count;
    }
}
