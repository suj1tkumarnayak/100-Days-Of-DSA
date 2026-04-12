package day_033_date_2026_04_10.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = { 10, -10, 20, 30 };
        int k = -5;
        System.out.println(longestSubarray(arr, k));
    }
    public static int longestSubarray(int[] arr, int k) {
        // code here
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        int max = 0, prefixSum = 0;

        for (int i = 0; i < len; i++) {
            prefixSum += arr[i];
            if(prefixSum == k){
                max = i+1;
            }

            int complement = prefixSum - k;

            if(map.containsKey(complement)){
                max = Math.max(max, i-map.get(complement));
            }
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum, i);
            }
        }

        return max;
    }
}
