package day_062_date_2026_05_31.array;

import java.util.ArrayList;
import java.util.List;

public class SubarrayList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subarrayListBetter(nums));
    }

    public static List<List<Integer>> subarrayListBetter(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int start = 0; start < n; start++){
            List<Integer> temp = new ArrayList<>();
            for(int end = start; end < n; end++){
                temp.add(nums[end]);
                result.add(new ArrayList<>(temp));
            }
        }

        return result;
    }
    // 1
    // 2
    // 3
    // 1, 2
    // 1, 3
    // 2, 3
    // 1, 2, 3

    public static List<List<Integer>> subarrayListBrute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int start = 0; start < n; start++){
            for(int end = start; end < n; end++){

                List<Integer> temp = new ArrayList<>();

                for(int k = start; k <= end; k++){
                    temp.add(nums[k]);
                }

                result.add(temp);
            }
        }

        return result;
    }
    public static List<List<Integer>> subarrayList(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        // i is the starting index of the subarray
        for (int i = 0; i < n; i++) {
            List<Integer> currentSubarray = new ArrayList<>();
            // j is the ending index of the subarray
            for (int j = i; j < n; j++) {
                currentSubarray.add(nums[j]);
                // Add a copy of the current continuous slice to the result
                result.add(new ArrayList<>(currentSubarray));
            }
        }

        return result;
    }
}
