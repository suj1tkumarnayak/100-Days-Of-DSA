package day_037_date_2026_04_16.slidingwindow.revision;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 6};
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }
    
    public static int longestSubarray(int[] arr, int k) {
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum == k){
                max = Math.max(max, i+1);
            }

            int complement = sum - k;
            if(map.containsKey(complement)){
                max = Math.max(max, i-map.get(complement));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }
}
