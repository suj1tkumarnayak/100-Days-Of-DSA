package day_033_date_2026_04_10.hashing;

//https://www.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithZeroesAndOnes {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 1, 0, 0 };
        System.out.println(maxLen(arr));
    }
    public static int maxLen(int[] arr) {
        // Your code here
        int max = 0, len = arr.length, score = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if(arr[i] == 0){
                score -= 1;
            }else{
                score += 1;
            }

            if(score==0){
                max = i + 1;
            }

            if(map.containsKey(score)){
                max = Math.max(max, i - map.get(score));
            }

            if(!map.containsKey(score)){
                map.put(score, i);
            }
        }

        return max;
    }
}
