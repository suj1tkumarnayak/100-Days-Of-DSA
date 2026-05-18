package day_049_date_2026_05_18.sheet.arrays;

import java.util.HashMap;

public class SubarrayRangeWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int tar = -10;
        System.out.println(subArraySum(arr, tar));
    }
    private static int subArraySum(int arr[], int tar) {
        //  code here
        HashMap<Integer, Integer> map = new HashMap<>();
        // Base case: To handle subarrays that start from index 0
        map.put(0, 1);

        int currentSum = 0;
        int count = 0;

//        int[] arr = {10, 2, -2, -20, 10};

        for (int num : arr) {
            currentSum += num;

            // If (currentSum - tar) exists in map, it means a valid subarray ends here
            if (map.containsKey(currentSum - tar)) {
                count += map.get(currentSum - tar);
            }

            // Record the current prefix sum in the map
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
